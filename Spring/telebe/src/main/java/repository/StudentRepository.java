package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.StudentEntity;
import java.util.List;



public interface StudentRepository extends JpaRepository<StudentEntity, Integer>{
	// select * from students where owner = 'Elchin'
		List<StudentEntity> findAllByOwner(String username);
}
