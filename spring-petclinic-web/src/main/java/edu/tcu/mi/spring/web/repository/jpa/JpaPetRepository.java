package edu.tcu.mi.spring.web.repository.jpa;

import org.springframework.stereotype.Repository;

import edu.tcu.mi.spring.web.entity.Pet;
import edu.tcu.mi.spring.web.repository.PetRepository;

@Repository
public interface JpaPetRepository extends PetRepository, JpaGenericRepository<Pet> {
}
