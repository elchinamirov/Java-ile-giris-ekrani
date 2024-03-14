package az.developia.libraryelchinemirov.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import az.developia.libraryelchinemirov.entity.BookEntity;
import az.developia.libraryelchinemirov.entity.LibrarianEntity;

@Repository
public interface BookDAO extends JpaRepository<BookEntity, Long> {
	Page<BookEntity> findByLibrarian(LibrarianEntity librarian, Pageable pageable);		//kitabxanaciya esasen tapmaq methodu

}