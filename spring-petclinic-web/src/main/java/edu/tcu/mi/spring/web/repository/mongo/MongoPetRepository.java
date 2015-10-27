package edu.tcu.mi.spring.web.repository.mongo;

import org.springframework.stereotype.Repository;

import edu.tcu.mi.spring.web.entity.Pet;
import edu.tcu.mi.spring.web.repository.PetRepository;

@Repository
public interface MongoPetRepository extends PetRepository, MongoGenericRepository<Pet> {
}
