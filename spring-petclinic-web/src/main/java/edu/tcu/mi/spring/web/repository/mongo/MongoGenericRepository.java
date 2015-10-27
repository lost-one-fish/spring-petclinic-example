package edu.tcu.mi.spring.web.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MongoGenericRepository<T> extends MongoRepository<T, String> {

}
