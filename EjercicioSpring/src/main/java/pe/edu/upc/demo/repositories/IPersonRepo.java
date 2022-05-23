package pe.edu.upc.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.edu.upc.demo.entities.Person;

public interface IPersonRepo extends JpaRepository<Person, Integer>{

	@Query("SELECT p FROM Person p WHERE"
			+ " CONCAT(p.idPersona,p.fullName,p.dniPerson)"
			+ " LIKE %?1%")
	public List<Person> findAll(String palabraClave);
}
