package edu.tcu.mi.spring.web.repository;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;

import edu.tcu.mi.spring.web.entity.Pet;
import edu.tcu.mi.spring.web.entity.PetType;

@NoRepositoryBean
public interface PetRepository extends GenericRepository<Pet>{
	
	List<Pet> findByType(PetType type);
	List<Pet> findByTypeName(String typename);
}
