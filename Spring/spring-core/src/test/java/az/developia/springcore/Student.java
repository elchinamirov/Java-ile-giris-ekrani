package az.developia.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Primary
@Scope(scopeName= "prototype")

public class Student {
	private String name;
	private String surname;
	@Autowired
	@Qualifier(value = "myComputer")
private Computer computer;
	
	public Student() {
		name="John";
		surname="Amirov";
		System.out.println("\"Student object was created\"");
	}
	@PostConstruct
	private void init() {
		System.out.println("\"bean ok was created\"");
	}
	@PreDestroy
	public void des() {
		System.out.println("\"bean was dead\"");
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



	


