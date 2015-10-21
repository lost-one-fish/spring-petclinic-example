package edu.tcu.mi.spring.web.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.tcu.mi.spring.web.entity.User;

@Repository
public interface UserRepository extends GenericRepository<User> {
	
	
	public List<User> findByRole(String role);
}
