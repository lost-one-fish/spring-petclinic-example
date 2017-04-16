package edu.tcu.mi.spring.web.service;

import edu.tcu.mi.spring.web.entity.User;
import edu.tcu.mi.spring.web.repository.jpa.JpaGenericRepository;
import edu.tcu.mi.spring.web.repository.jpa.JpaUserRepository;
import edu.tcu.mi.spring.web.security.entity.PetclinicUserDetails;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractGenericService<User> implements UserDetailsService {

	@Autowired 
	private JpaUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
    	User user = repository.findOne(username);
    	if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new PetclinicUserDetails(user);
    }

    public List<User> findByRole(String role){
    	return repository.findByRole(role);
    }
    
	@Override
	JpaGenericRepository<User> getRepository() {
		return repository;
	}
    
}
