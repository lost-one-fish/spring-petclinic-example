package edu.tcu.mi.spring.web.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import edu.tcu.mi.spring.web.repository.GenericRepository;

public abstract class GenericService<T> {

	protected static Logger logger = Logger.getLogger(GenericService.class);

	protected abstract GenericRepository<T> getRepository();
	
	public synchronized T save(T entity) {
		return getRepository().save(entity);		
	}
	
	public synchronized T findOne(String id) {
		return getRepository().findOne(id);
	}

	public synchronized List<T> findAll() {
		return getRepository().findAll();
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
