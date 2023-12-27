package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entity.StudentEntity;
import jakarta.validation.Valid;
import response.StudentResponseModel;
import service.StudentService;

@RestController

@RequestMapping(path = "/students")
@CrossOrigin(origins = "*")

public class StudentController {
	
	@Autowired
	private StudentService service;	
	@PostMapping
	public void addStudent(@Valid @RequestBody StudentEntity p, BindingResult br) {
		service.add(p, br);

}
@GetMapping
public StudentResponseModel findAll() {

	return service.findAllByOwner();	}

@DeleteMapping(path = "/{id}") 

public void deleteById(@PathVariable Integer id) {
	service.deleteById(id);
	}

@PutMapping

public void update(@Valid @RequestBody StudentEntity p, BindingResult br) {
	service.update(p, br);
}


	
	
		
	@GetMapping(path ="/{id}")
	public StudentEntity findById(@PathVariable Integer id ){
		
		return service.findById(id);		}



}

/*
 
@ExceptionHandler                                             .
public String handleOurRuntimeException(RuntimeException e) {
return e.getMessage();}


            Elverissiz oldugu ucun yeni class yaradildi
 
*/







