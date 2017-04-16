package edu.tcu.mi.spring.web.repository.jpa;

import edu.tcu.mi.spring.web.entity.Pet;
import edu.tcu.mi.spring.web.entity.PetType;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPetRepository extends JpaGenericRepository<Pet> {

	List<Pet> findByType(PetType type);

	List<Pet> findByTypeName(String typename);
}
