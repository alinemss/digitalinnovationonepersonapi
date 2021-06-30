package one.digitalinovation.personapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import one.digitalinovation.personapi.Entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
