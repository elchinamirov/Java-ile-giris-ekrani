package az.developia.libraryelchinemirov.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import az.developia.libraryelchinemirov.entity.StudentEntity;

@Repository
public interface StudentDAO extends JpaRepository<StudentEntity, Long> {

}