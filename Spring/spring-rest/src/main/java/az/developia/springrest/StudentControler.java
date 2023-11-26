 package az.developia.springrest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentControler {
	private String name;
	private String adress;
	private String country;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public StudentControler(String name, String adress, String country, int age) {
		super();
		this.name = name;
		this.adress = adress;
		this.country = country;
		this.age = age;
	}
	@GetMapping(path = "/student-object")
	public StudentControler showMeSomeStudents() {
		StudentControler s= new StudentControler("Elchin", "Baku", "Azerbaijan", 19);
		return s;
}
}