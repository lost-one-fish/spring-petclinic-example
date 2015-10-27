package edu.tcu.mi.spring.web.repository;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;

import edu.tcu.mi.spring.web.entity.User;

@NoRepositoryBean
public interface UserRepository extends GenericRepository<User>{

	List<User> findByRole(String role);
}
