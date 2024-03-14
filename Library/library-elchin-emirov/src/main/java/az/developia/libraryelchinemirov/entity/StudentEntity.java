package az.developia.libraryelchinemirov.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "students")
public class StudentEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

@NotEmpty(message = "Bos qoymaq olmaz")
@Size(min = 2, message = "Minimum 2 simvol yazmaq lazimdir")
@Size(max = 40, message = "Maksimum 40 simvol yazmaq lazimdir")
@Column(columnDefinition = "VARCHAR(30)")
private String name;

@NotEmpty(message = "Bos qoymaq olmaz")
@Size(min = 2, message = "Minimum 2 simvol yazmaq lazimdir")
@Size(max = 40, message = "Maksimum 40 simvol yazmaq lazimdir")
@Column(columnDefinition = "VARCHAR(30)")
private String surname;

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



}