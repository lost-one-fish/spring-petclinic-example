package edu.tcu.mi.spring.web.repository.jpa;

import org.springframework.stereotype.Repository;

import edu.tcu.mi.spring.web.entity.User;
import edu.tcu.mi.spring.web.repository.UserRepository;

@Repository
public interface JpaUserRepository extends UserRepository, JpaGenericRepository<User>{

}
