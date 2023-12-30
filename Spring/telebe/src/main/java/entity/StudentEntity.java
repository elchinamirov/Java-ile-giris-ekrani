package entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "students")
public class StudentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; // db
	
	@NotNull(message = "Ad mutleqdir")
	 @NotEmpty(message = "Adi bos qoymaq olmaz") 
	 @Size(min = 2,message = "Ad minimum 2 simvol olmalidir")
	 @Size(max = 50,message = "Ad maksimum 50 simvol olmalidir")
	
	private String name; // user
	
	@NotNull(message = "Soyad mutleqdir")
	 @NotEmpty(message = "Soyadi bos qoymaq olmaz") 
	 @Size(min = 2,message = "Soyad minimum 2 simvol olmalidir")
	 @Size(max = 50,message = "Soyad maksimum 50 simvol olmalidir")
	 
	
	private String surname; // user
	
	@NotNull(message = "Yas mutleqdir")
	 @Min(value = 0,message = "Yas menfi ola bilmez")
	 @Max(value = 100,message = "Yas maksimum 100 ola biler")
	
	private int age; // user
	
	
	
	@Column(unique = true) //MySql xanalardanda ede bilerdik
	
	@NotNull(message = "Sinif mutleqdir")
	 @NotEmpty(message = "Sinif bos qoymaq olmaz") 
	 @Size(min = 1,message = "Sinif minimum 1 simvol olmalidir")
	 @Size(max = 30,message = "Sinif maksimum 30 simvol olmalidir")
	
	//@Pattern(regexp = "[0-9a-zA-Z]{3}-[0-9]{3}",message = "hdashjksd") // 565-965

	private int sinif; // user
	
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime register; // bar code

	private String owner;
	
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
	
	

	public StudentEntity(Integer id, String name, String surname, int age, int sinif, LocalDateTime register) {
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

	public StudentEntity() {
}
	public String getOwner() {
		return owner;
		
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}

	
	
}
