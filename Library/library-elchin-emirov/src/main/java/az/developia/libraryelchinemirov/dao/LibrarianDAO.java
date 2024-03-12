package az.developia.libraryelchinemirov.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import az.developia.libraryelchinemirov.entity.LibrarianEntity;

@Repository
		public interface LibrarianDAO extends JpaRepository<LibrarianEntity, Integer>{
			

		}

