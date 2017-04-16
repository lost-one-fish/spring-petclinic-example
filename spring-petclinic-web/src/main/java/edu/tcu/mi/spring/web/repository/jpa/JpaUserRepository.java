package edu.tcu.mi.spring.web.repository.jpa;

import edu.tcu.mi.spring.web.entity.User;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserRepository extends JpaGenericRepository<User> {

	List<User> findByRole(String role);
}
