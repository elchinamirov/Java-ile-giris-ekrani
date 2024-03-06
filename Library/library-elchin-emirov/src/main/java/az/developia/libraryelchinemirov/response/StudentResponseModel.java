package az.developia.libraryelchinemirov.response;

import java.time.LocalDateTime;
import java.util.List;

import az.developia.libraryelchinemirov.dao.StudentDAO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentResponseModel {
private List<StudentDAO> students;
private LocalDateTime now;
}
