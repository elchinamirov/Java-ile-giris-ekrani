package az.developia.libraryelchinemirov.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.libraryelchinemirov.entity.Borrowed;
import az.developia.libraryelchinemirov.entity.StudentEntity;

public interface BorrowedBookDAO extends JpaRepository<Borrowed, Integer>{
List<Borrowed> findByStudent(StudentEntity studentid);
List<Borrowed> findByStudentid(StudentEntity studentid);

}
