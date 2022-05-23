package pe.edu.upc.demo.serviceimplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Person;
import pe.edu.upc.demo.repositories.IPersonRepo;
import pe.edu.upc.demo.serviceinterface.IPersonService;

@Service
public class PersonServiceImpls implements IPersonService{
	
	@Autowired
	private IPersonRepo rPerson;
	
	@Override
	public void insert(Person person) {
		rPerson.save(person);
	}

	@Override
	public List<Person> list(String palabraClave) {
		if(palabraClave != null) {
			return rPerson.findAll(palabraClave);
		}
		return rPerson.findAll();
	}

	@Override
	public void delete(int id) {
		rPerson.deleteById(id);	
	}

	@Override
	public Person get(int id) {
		return rPerson.findById(id).get();
	}

	
}
