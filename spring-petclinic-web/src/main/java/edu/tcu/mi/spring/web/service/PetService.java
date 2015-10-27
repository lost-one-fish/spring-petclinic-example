package edu.tcu.mi.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.tcu.mi.spring.web.entity.Pet;
import edu.tcu.mi.spring.web.entity.PetType;
import edu.tcu.mi.spring.web.repository.GenericRepository;
import edu.tcu.mi.spring.web.repository.PetRepository;

@Service
public class PetService extends AbstractGenericService<Pet>{

	@Autowired 
	PetRepository repository;
	
	@Override
	GenericRepository<Pet> getRepository() {
		return repository;
	}

	public List<Pet> findByType(PetType type){
		return repository.findByType(type);
	}

	public List<Pet> findByTypeName(String typename){
		return repository.findByTypeName(typename);
	}
}
