package edu.tcu.mi.spring.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

import com.google.gson.Gson;

import edu.tcu.mi.spring.web.security.Authority;

@Entity
@Table(name = "User")
@Document
public class User {
	@org.springframework.data.annotation.Id
	@Id
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "role")
	private String role;
	
	@Transient
	private static ShaPasswordEncoder encoder = new ShaPasswordEncoder();
	
	@Transient
	public static final String SEED = "Petclinic";
	
	public User(){
		this.role = Authority.ROLE_ANONYMOUS;
	}
	
	public User(String username, String password, String role){
		this();
		this.username = username.trim();
		this.password = encoder.encodePassword(password.trim(), SEED);
		this.role = role;
	}
	
	public void setUsername(String username) {
		this.username = username.trim();
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password){
		this.password = encoder.encodePassword(password.trim(), SEED);
	}
	
	public String getPassword() {
		return password;
	}

	public String getRole(){
		return role;
	}


	@Override
	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
	
}
