package az.developia.libraryelchinemirov.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import az.developia.libraryelchinemirov.dao.StudentDAO;
import az.developia.libraryelchinemirov.entity.Borrowed;
import az.developia.libraryelchinemirov.entity.StudentEntity;
import az.developia.libraryelchinemirov.exception.OurRuntimeException;
import az.developia.libraryelchinemirov.service.LibrarianService;
import az.developia.libraryelchinemirov.service.StudentService;

@RestController
@RequestMapping(path = "/student")
@CrossOrigin(origins = "*")
public class StudentRestController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private StudentDAO studentDAO;
	
	@Autowired
	private LibrarianService librarianService;

	@GetMapping
	@PreAuthorize(value = "hasAuthority('ROLE_LIBRARIAN')")				//sagirlerin hamisini gosterir
	public List<StudentEntity> showStudents() {
		return studentDAO.findAll();
	}

	@GetMapping(path = "/{id}")
	@PreAuthorize(value = "hasAuthority('ROLE_LIBRARIAN')")
	public StudentEntity findById(@PathVariable(name = "id") Long id) {		//sagirdi id-sine gore tapir

		return studentDAO.findById(id).get();
	}

	

	@PutMapping
	@PreAuthorize(value = "hasAuthority('ROLE_LIBRARIAN')")
																							//sagirdi redakte edir
	public void update(@javax.validation.Valid @RequestBody StudentEntity s) {
		studentService.update(s);
	}

	@DeleteMapping(path = "/delete/{id}")
	@PreAuthorize(value = "hasAuthority('ROLE_LIBRARIAN')")

	public void deletefunction(@PathVariable Long id) {										//sagirdi id-sine gore silir
		if (studentDAO.existsById(id)) {
			studentService.DeleteStudent(id);
		} else {
			throw new OurRuntimeException("sagird tapilmadi", null);
		}

	}
	@PostMapping(path = "/register")
	@PreAuthorize(value = "hasAuthority('ROLE_LIBRARIAN')")
    public void registerStudent(@Valid @RequestBody StudentEntity student) {			//sagird register edir
        studentService.registerStudent(student);
    }
	
	 @PostMapping("/returnBook")
	 @PreAuthorize(value = "hasAuthority('ROLE_LIBRARIAN')")								//kitabi geri qaytarilmasi qeyd edir
	    public ResponseEntity<String> returnBook(@RequestParam Long takenBookId) {
	      
	            studentService.returnBook(takenBookId);
	            return ResponseEntity.ok("Kitab ugurla qaytarildi");
	      
	    }

	    @GetMapping("/taken-books/{studentId}")
	    @PreAuthorize(value = "hasAuthority('ROLE_LIBRARIAN')")	
	    public ResponseEntity<List<Borrowed>> getTakenBooksByStudent(@PathVariable Long studentId) {
	       
	            List<Borrowed> takenBooks = librarianService.getTakenBooksByStudent(studentId);		//goturulmus kitablari sagirde gore tapir
	            return ResponseEntity.ok(takenBooks);
	       
	    }

}