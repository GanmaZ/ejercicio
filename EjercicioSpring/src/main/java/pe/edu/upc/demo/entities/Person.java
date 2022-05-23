package pe.edu.upc.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPersona;
	
	@Column(name = "fullName", nullable = false, length = 50)
	private String fullName;
	@Column(name = "dniPerson", nullable = false, length = 50)
	private String dniPerson;

	public Person() {
		super();
		//TODO Auto-generated constructor stub
	}

	public Person(int idPersona, String fullName, String dniPerson) {
		super();
		this.idPersona = idPersona;
		this.fullName = fullName;
		this.dniPerson = dniPerson;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDniPerson() {
		return dniPerson;
	}

	public void setDniPerson(String dniPerson) {
		this.dniPerson = dniPerson;
	}
	
	
}
