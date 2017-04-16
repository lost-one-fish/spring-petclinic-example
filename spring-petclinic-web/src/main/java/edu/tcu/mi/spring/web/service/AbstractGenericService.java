package edu.tcu.mi.spring.web.service;

import edu.tcu.mi.spring.web.repository.jpa.JpaGenericRepository;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public abstract class AbstractGenericService<T> {

	abstract JpaGenericRepository<T> getRepository();
	
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
