package pe.edu.upc.demo.serviceinterface;

import java.util.List;

import pe.edu.upc.demo.entities.Person;

public interface IPersonService {
	
	public void insert(Person person);
	public List<Person> list(String palabraClave);
	public void delete(int id);
	public Person get(int id);
	

}
