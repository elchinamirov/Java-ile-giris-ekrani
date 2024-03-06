package az.developia.libraryelchinemirov.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import az.developia.libraryelchinemirov.entity.BookEntity;
@Repository
public interface BookDAO extends JpaRepository<BookEntity, Integer>{

	

}
