package edu.tcu.mi.spring.web.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.google.common.collect.Lists;

import edu.tcu.mi.spring.web.repository.GenericRepository;
import edu.tcu.mi.spring.web.repository.jpa.JpaGenericRepository;
import edu.tcu.mi.spring.web.repository.mongo.MongoGenericRepository;

public abstract class AbstractGenericService<T> {

	static Logger logger = Logger.getLogger(AbstractGenericService.class);

	abstract GenericRepository<T> getRepository();
	
	public synchronized T save(T entity) {
		return getRepository().save(entity);		
	}
	
	public synchronized T findOne(String id) {
		return getRepository().findOne(id);
	}

	public synchronized List<T> findAll() {
		GenericRepository<T> repository = getRepository();
		if(repository instanceof MongoGenericRepository) {
			return ((MongoGenericRepository<T>)repository).findAll();
		}
		if(repository instanceof JpaGenericRepository) {
			return ((JpaGenericRepository<T>)repository).findAll();
		}
		return Lists.newArrayList();
	}

	public synchronized Page<T> findAll(Pageable pageable) {
		return getRepository().findAll(pageable);
	}
	
	public synchronized long count() {
		return getRepository().count();
	}
	
	public synchronized boolean delete(String id) {
		T entity = getRepository().findOne(id);
		if(entity != null){
			getRepository().delete(id);
			return true;
		} else {
			return false;
		}
	}

}
