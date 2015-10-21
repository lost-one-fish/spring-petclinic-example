package edu.tcu.mi.spring.web.security;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import edu.tcu.mi.spring.web.entity.User;
import edu.tcu.mi.spring.web.service.UserService;

@Component("GaduoAuthenticationProvider")
public class GaduoAuthenticationProvider implements AuthenticationProvider {
	public static Logger logger = Logger.getLogger(GaduoAuthenticationProvider.class);

    @Autowired private UserService service;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = (String)authentication.getCredentials();
		ShaPasswordEncoder encoder = new ShaPasswordEncoder();
		password = encoder.encodePassword(password, User.SEED);
		UserDetails user = service.loadUserByUsername(username);
		if (user == null) {
			logger.error("Username not found.");
            throw new BadCredentialsException("Username not found.");
        }
 
        if (!password.equals(user.getPassword())) {
			logger.error("Wrong password.");
            throw new BadCredentialsException("Wrong password.");
        }
		logger.error("Pass Validation.");
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        
        return new UsernamePasswordAuthenticationToken(user, password, authorities);
   
	}

	/** (non-Javadoc)
	 * @see org.springframework.security.authentication.AuthenticationProvider#supports(java.lang.Class)
	 * 權限驗證
	 */
	@Override
	public boolean supports(Class<?> authentication) {
		if(authentication == null) return false;
        return Authentication.class.isAssignableFrom(authentication);
	}

}
