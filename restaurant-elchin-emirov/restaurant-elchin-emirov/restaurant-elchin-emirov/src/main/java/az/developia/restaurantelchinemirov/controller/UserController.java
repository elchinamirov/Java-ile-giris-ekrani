package az.developia.restaurantelchinemirov.controller;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.restaurantelchinemirov.model.UserEntity;
@RestController
	@RequestMapping
	@CrossOrigin(origins="*")
public class UserController {
	
	@Autowired 
	private UserDAO userDAO;
	
	
	@GetMapping(path="/login")
	public void login() {
		
	}
	
	@PostMapping(path = "/signup")
	public void signup(@Valid @RequestBody UserEntity user,BindingResult br ) {
	if(br.hasErrors()) {
		System.out.println("Məlumatların tamlığı pozulub");
	}
	if (userDAO.findById(user.getUsername()).isPresent()) {
		System.out.println("Bu Username artıq qeydiyyat olunub");
		
	}
	user.setPassword("{noop}"+user.getPassword());
	userDAO.save(user);
	userDAO.addAdminAuthorities(user.getUsername());
	}
	
	

}
