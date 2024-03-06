package az.developia.libraryelchinemirov.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.libraryelchinemirov.dao.UserDAO;
@RestController
@RequestMapping
@CrossOrigin(origins="*")
public class UserRestController {
	
	@Autowired 
	private UserDAO userDAO;
	
	
	@GetMapping(path="/login")
	public void login() {
		
	}}