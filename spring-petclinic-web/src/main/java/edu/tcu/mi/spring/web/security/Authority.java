package edu.tcu.mi.spring.web.security;

import org.springframework.security.core.GrantedAuthority;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.gson.Gson;

public class Authority implements GrantedAuthority{

	private static final long serialVersionUID = 1L;
	
	
	public final static String ROLE_ANONYMOUS = "ROLE_ANONYMOUS";
    public final static String ROLE_USER = "ROLE_USER";
    public final static String ROLE_ADMIN = "ROLE_ADMIN";

    private String auth;
    
    public Authority() {
        this.auth = ROLE_ANONYMOUS;
    }
    
	public Authority(String role) {
        this.auth = role;
	}

	@Override
	public String getAuthority() {
        return this.auth;
	}

	@Override
    public boolean equals(Object that) {
        if(that instanceof Authority) {
        	Authority a = (Authority) that;
            return Objects.equal(auth, a.auth);
        }
        return false;
    }
    
	@Override
    public int hashCode() {
        return Objects.hashCode(auth);
    }

	@Override
	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
    
    
}
