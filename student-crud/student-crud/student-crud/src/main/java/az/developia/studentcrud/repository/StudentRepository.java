package az.developia.studentcrud.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.studentcrud.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
}
