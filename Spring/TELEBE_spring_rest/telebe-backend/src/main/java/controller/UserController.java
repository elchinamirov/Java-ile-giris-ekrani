package controller;





import java.util.Optional;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entity.UserEntity;
import repository.UserRepository;
@RestController

@RequestMapping(path = "/users")


@CrossOrigin(origins = "*")

public class UserController {
	
	private UserRepository repository;
	
	@GetMapping(path = "/login") 
	public String login( ) {
		 
		String username=SecurityContextHolder.getContext().getAuthentication().getName();
		
		Optional<UserEntity> findById = repository.findById(username);
		UserEntity userEntity = findById.get();
		String type = userEntity.getType();
		System.out.println(type);
		return type;
		
		
	}
}