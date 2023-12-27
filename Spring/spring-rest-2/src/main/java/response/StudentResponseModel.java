package response;
import java.time.LocalDateTime;
import java.util.List;

import entity.StudentEntity;
 public class StudentResponseModel {
private List<StudentEntity> students;
private LocalDateTime now;

public List<StudentEntity> getStudents() {
	return students;
}

public void setStudents(List<StudentEntity> students) {
	this.students = students;
}

public LocalDateTime getNow() {
	return now;
}

public void setNow(LocalDateTime now) {
	this.now = now;
}



}
