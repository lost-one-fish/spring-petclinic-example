package edu.tcu.mi.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.tcu.mi.spring.web.entity.User;
import edu.tcu.mi.spring.web.repository.GenericRepository;
import edu.tcu.mi.spring.web.repository.UserRepository;
import edu.tcu.mi.spring.web.security.entity.GaduoUserDetails;

@Service
public class UserService extends GenericService<User> implements UserDetailsService, MessageSourceAware {

	@Autowired 
	private UserRepository repository;
	@Autowired 
    private MessageSource messageSource;
	
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
    	User user = repository.findOne(username);
    	if (user != null)
    		logger.info(user.toString());
    	else 
    		throw new UsernameNotFoundException(username);
		return new GaduoUserDetails(user);
    }

    public List<User> findByRole(String role){
    	return repository.findByRole(role);
    }
    
    
	@Override
	public void setMessageSource(MessageSource _messageSource) {
		messageSource = _messageSource;
	}

	@Override
	protected GenericRepository<User> getRepository() {
		return repository;
	}
    
}
