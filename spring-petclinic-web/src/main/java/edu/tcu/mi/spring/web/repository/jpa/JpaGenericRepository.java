package edu.tcu.mi.spring.web.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface JpaGenericRepository<T> extends JpaRepository<T, String> {

}
