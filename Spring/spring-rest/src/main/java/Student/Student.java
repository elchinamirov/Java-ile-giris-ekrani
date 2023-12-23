package Student;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; // db
	private String name; // user
	private String surname; // user
	private int age; // user
	@Column(unique = true) //MySql xanalardanda ede bilerdik
	private int sinif; // user
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime register; // bar code

	
	
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSinif() {
		return sinif;
	}

	public void setSinif(int sinif) {
		this.sinif = sinif;
	}

	public LocalDateTime getRegister() {
		return register;
	}

	public void setRegister(LocalDateTime register) {
		this.register = register;
	}
	
	

	public Student(Integer id, String name, String surname, int age, int sinif, LocalDateTime register) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.sinif = sinif;
		this.register = register;
	}

	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", surname=" + surname + ", age=" + age + ", sinif=" + sinif
				+ ", register=" + register + "]";
	}
	
	public Student() {
}
	
	

	
	

}
