package edu.tcu.mi.spring.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<T>  extends JpaRepository<T, String>{
	
	// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.repositories
}