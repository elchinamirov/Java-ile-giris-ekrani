package az.developia.libraryelchinemirov.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import az.developia.libraryelchinemirov.entity.AuthoritySiyahi;

@Repository
public interface AuthoritySiyahiDAO extends JpaRepository<AuthoritySiyahi, Integer>{
	

}
