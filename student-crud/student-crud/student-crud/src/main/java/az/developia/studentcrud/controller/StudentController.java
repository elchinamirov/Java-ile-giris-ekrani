package az.developia.studentcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import az.developia.studentcrud.model.Student;
import az.developia.studentcrud.repository.StudentRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/students")
@CrossOrigin(origins = "*")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;

	@PostMapping
	public Student save(@Valid @RequestBody Student student, BindingResult result){

		if(result.hasErrors()) {

        throw new RuntimeException("Məlumatlar tam deyil");

    }
		return studentRepository.save(student);
	}
	
	@GetMapping
	public List<Student> findAlL(){
		return studentRepository.findAll();
		}
	
	@DeleteMapping(path = "/{id}")
	public void deleteById(@PathVariable Integer id) {
		studentRepository.deleteById(id);
    }
	
	@GetMapping(path = "/{id}")
	public Student findById(@PathVariable Integer id) {
		return studentRepository.findById(id).get();
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)

	public String handleRunTimeException(RuntimeException exception){

		return exception.getMessage();

	}
	}