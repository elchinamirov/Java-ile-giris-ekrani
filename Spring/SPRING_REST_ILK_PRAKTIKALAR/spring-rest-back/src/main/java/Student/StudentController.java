package Student;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping(path = "/students")
@CrossOrigin(origins = "*")

public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	
@PostMapping

public void addStudent(@RequestBody Student student) {
	// add this object to database
	// id must be generated on db
	// register must config
	
	student.setRegister(LocalDateTime.now());
	student.setId(null);
	studentRepository.save(student);
	
	//System.out.println(product);
}
@GetMapping
public List <Student> findAll(){
	
	return studentRepository.findAll();
	}

@DeleteMapping(path="/{id}") //   /product/3

public String deleteById(@PathVariable Integer id) {
	
Optional<Student> finded = studentRepository.findById(id);

 
if (finded.isPresent()) {
	
	studentRepository.deleteById(id);
	return "Tapdim ve sildim";
	
}else {
	return "ID tapilmadi , id = "+id;

}
}

@PutMapping

public void update(@RequestBody Student student) {
	
	if (student.getId()==null || student.getId()<1) {
		throw new OurRuntimeException("ID bos ola ve ya movcud olmaya bilmez");
	}
	Optional<Student> finded = studentRepository.findById(student.getId());

	if (finded.isPresent()) {
		
		studentRepository.save(student);
		
	}else {
		throw new OurRuntimeException("ID tapilmadi ve redakte etmek olmaz");
	}	
}


	
	@GetMapping(path = "/hamiya")   

	public  String test( ){
		
	           return "test";
		}
	@GetMapping(path ="/{id}")
	public Student findById(@PathVariable Integer id ){
		
		return studentRepository.findById(id).get();
		}



}

/*
 
@ExceptionHandler                                             .
public String handleOurRuntimeException(RuntimeException e) {
return e.getMessage();}


            Elverissiz oldugu ucun yeni class yaradildi
 
*/







