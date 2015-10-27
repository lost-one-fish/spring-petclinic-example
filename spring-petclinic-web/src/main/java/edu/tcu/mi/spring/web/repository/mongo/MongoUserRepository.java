package edu.tcu.mi.spring.web.repository.mongo;

import org.springframework.stereotype.Repository;

import edu.tcu.mi.spring.web.entity.User;
import edu.tcu.mi.spring.web.repository.UserRepository;

@Repository
public interface MongoUserRepository extends UserRepository, MongoGenericRepository<User>{

}
