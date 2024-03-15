package az.developia.libraryelchinemirov.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "students")
public class StudentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message= "Bos qoymaq olmaz")
	@Size(min=2,message="Minimum 2 simvol yazmaq lazimdir")
	@Size(max=20,message="Maksimum 20 simvol yazmaq lazimdir")
	@Column(columnDefinition="VARCHAR(20)")
	private String name;
	
	@NotEmpty(message= "Bos qoymaq olmaz")
	@Size(min=2,message="Minimum 2 simvol yazmaq lazimdir")
	@Size(max=20,message="Maksimum 20 simvol yazmaq lazimdir")
	@Column(columnDefinition="VARCHAR(20)")
	private String surname;
	
	@NotEmpty(message= "Bos qoymaq olmaz")
	@Pattern(regexp = "((\\(\\d{3}\\) ?)|(\\d{3}-))?\\d{3}-\\d{4}",message = "Telefonu duzgun formada yazin. Meselen 000-000-0000")
	@Column(columnDefinition="VARCHAR(20)")
	@Size(max=20,message="Maksimum 20 simvol yazmaq lazimdir")
	private String phone;
	
	@NotEmpty(message= "Bos qoymaq olmaz")
	@Size(min=2,message="Minimum 2 simvol yazmaq lazimdir")
	@Size(max=200,message="Maksimum 200 simvol yazmaq lazimdir")
	@Column(columnDefinition="VARCHAR(200)")
	private String address;
	
	@NotEmpty(message= "Bos qoymaq olmaz")
	@Size(min=2,message="Minimum 2 simvol yazmaq lazimdir")
	@Size(max=20,message="Maksimum 20 simvol yazmaq lazimdir")
	@Column(columnDefinition="VARCHAR(20)")
	private String username;
	
	@NotEmpty(message= "Bos qoymaq olmaz")
	@Size(min=2,message="Minimum 2 simvol yazmaq lazimdir")
	@Size(max=20,message="Maksimum 20 simvol yazmaq lazimdir")
	@Column(columnDefinition="VARCHAR(20)")
	private String password;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}



	}