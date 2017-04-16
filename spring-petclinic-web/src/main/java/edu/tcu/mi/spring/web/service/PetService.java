package edu.tcu.mi.spring.web.service;

import edu.tcu.mi.spring.web.entity.Pet;
import edu.tcu.mi.spring.web.entity.PetType;
import edu.tcu.mi.spring.web.repository.jpa.JpaGenericRepository;
import edu.tcu.mi.spring.web.repository.jpa.JpaPetRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService extends AbstractGenericService<Pet>{

	@Autowired
	JpaPetRepository repository;
	
	@Override
	JpaGenericRepository<Pet> getRepository() {
		return repository;
	}

	public List<Pet> findByType(PetType type){
		return repository.findByType(type);
	}

	public List<Pet> findByTypeName(String typename){
		return repository.findByTypeName(typename);
	}
}
