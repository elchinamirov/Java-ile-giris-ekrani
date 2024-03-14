package az.developia.libraryelchinemirov.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.libraryelchinemirov.entity.LibrarianEntity;

public interface LibrarianDAO extends JpaRepository<LibrarianEntity, Long> {

}