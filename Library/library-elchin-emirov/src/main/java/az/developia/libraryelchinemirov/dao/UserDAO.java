package az.developia.libraryelchinemirov.dao;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import az.developia.libraryelchinemirov.entity.UserEntity;

@Transactional
public interface UserDAO extends JpaRepository<UserEntity, String> {

	@Query(value = "insert into authorities (username,authority) select ?1,authority from roles where admin=1",nativeQuery = true)
	@Modifying
	void addAdminAuthorities(String username);		// register ederken user ve admin ucun rol tertib edir
	
	@Query(value = "insert into authorities (username,authority) select ?1,authority from roles where admin=0",nativeQuery = true)
	@Modifying
	void addUserAuthorities(String username);		// her user ucun admin olmayan rollar verir (register ederken her user ucun admin olmayan  rol tertib edir)
	
}