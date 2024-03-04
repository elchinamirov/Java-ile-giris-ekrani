package az.developia.restaurantelchinemirov.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import az.developia.restaurantelchinemirov.model.UserEntity;
@Transactional
public interface UserDAO extends JpaRepository<UserEntity, String> {
	@Query(value = "insert into authorities(username,authority) select ?1,auhtority_list where admin",nativeQuery = true)
    @Modifying
    void addAdminAuthorities(String username);
}