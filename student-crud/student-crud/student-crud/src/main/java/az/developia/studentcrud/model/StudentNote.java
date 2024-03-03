package az.developia.studentcrud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StudentNote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
	
private String note;

private Integer studentId;


public Integer getId() {
	return id;
}


public void setId(Integer id) {
	this.id = id;
}


public String getNote() {
	return note;
}


public void setNote(String note) {
	this.note = note;
}


public Integer getStudentId() {
	return studentId;
}


public void setStudentId(Integer studentId) {
	this.studentId = studentId;
}

}
