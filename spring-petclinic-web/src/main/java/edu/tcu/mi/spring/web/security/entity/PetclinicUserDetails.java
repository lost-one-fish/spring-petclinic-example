package edu.tcu.mi.spring.web.security.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import edu.tcu.mi.spring.web.entity.User;
import edu.tcu.mi.spring.web.security.Authority;

public class PetclinicUserDetails implements UserDetails {
	private static final long serialVersionUID = 1L;
	public static Logger logger = Logger.getLogger(PetclinicUserDetails.class);
	private User user;

    public PetclinicUserDetails() {
        this.user = new User();
    }
    
	public PetclinicUserDetails(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = null;

        if (Authority.ROLE_ANONYMOUS.equals(user.getRole())) {
            authorities = new ArrayList<>();
            authorities.add(new Authority(Authority.ROLE_ANONYMOUS));
        }

        if (Authority.ROLE_USER.equals(user.getRole())) {
            authorities = new ArrayList<>();
            authorities.add(new Authority(Authority.ROLE_ANONYMOUS));
            authorities.add(new Authority(Authority.ROLE_USER));
        }

        if (Authority.ROLE_ADMIN.equals(user.getRole())) {
            authorities = new ArrayList<>();
            authorities.add(new Authority(Authority.ROLE_ANONYMOUS));
            authorities.add(new Authority(Authority.ROLE_USER));
            authorities.add(new Authority(Authority.ROLE_ADMIN));
        }
    	logger.info(authorities);
        
        return authorities;
	}

	@Override
	public String getPassword() {
		if(user == null)
			return null;
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		if(user == null)
			return null;
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
