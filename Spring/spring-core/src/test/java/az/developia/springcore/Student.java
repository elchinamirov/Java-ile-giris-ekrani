package az.developia.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary

public class Student {
	private String name;
	private String surname;
	@Autowired
	@Qualifier(value = "myComputer")
private Computer computer;
	
	public Student() {
		name="Elchin";
		surname="Amirov";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Student(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}
	public Computer getComputer() {
		return computer;
	}
	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	}



	


