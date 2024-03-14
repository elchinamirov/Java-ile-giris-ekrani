package az.developia.libraryelchinemirov.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.libraryelchinemirov.entity.Borrowed;
import az.developia.libraryelchinemirov.entity.StudentEntity;

public interface BorrowedBookDAO extends JpaRepository<Borrowed, Long>{
	 List<Borrowed> findByStudent(StudentEntity student);	//Telebeye esasen tapmaq ucun
	 List<Borrowed> findByStudentId(Long studentId);			//telebenin id'sine esasen tapmaq ucun

}