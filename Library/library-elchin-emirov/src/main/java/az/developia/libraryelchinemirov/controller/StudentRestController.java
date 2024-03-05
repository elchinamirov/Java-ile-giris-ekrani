package az.developia.libraryelchinemirov.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import az.developia.libraryelchinemirov.dao.StudentDAO;
import az.developia.libraryelchinemirov.entity.StudentEntity;
import az.developia.libraryelchinemirov.exception.OurRuntimeException;
import az.developia.libraryelchinemirov.service.StudentService;

@RestController
@RequestMapping(path = "/students")
@CrossOrigin(origins = "*")
public class StudentRestController {
	private StudentService studentService;
	
	@Autowired
	private StudentDAO studentDAO;
	
	@GetMapping
	@PreAuthorize(value = "hasAuthority('ROLE_GET_STUDENT')")
	public List<StudentEntity> showStudents() {
		return studentDAO.findAll();
	}
	@PostMapping
	@PreAuthorize(value = "hasAuthority('ROLE_ADD_STUDENT')") // 403 200
	public void addStudent(@RequestBody StudentEntity student) {
		student.setId(null);
		studentDAO.save(student);
	}
	
	@DeleteMapping(path = "/{id}")
	@PreAuthorize(value = "hasAuthority('ROLE_DELETE_STUDENT')")
	public String deleteById(@PathVariable Integer id) {
		Optional<StudentEntity> finded = studentDAO.findById(id);
		if (finded.isPresent()) {
			studentDAO.deleteById(id);
			return "tapdim ve sildim";
		} else {
			// return "id tapilmadi, id = " + id;
			//
			throw new OurRuntimeException("id tapilmadi, id = " + id);
	}
	}
	
	@PutMapping
	@PreAuthorize(value = "hasAuthority('ROLE_UPDATE_STUDENT')")
	public void update(@RequestBody StudentEntity student) {
		if (student.getId() == null || student.getId() < 1) {
			throw new OurRuntimeException("id bos veya olmayan ola bilmez");
		}
		Optional<StudentEntity> finded = studentDAO.findById(student.getId());
		if (finded.isPresent()) {
			studentDAO.save(student);
		} else {
			throw new OurRuntimeException("id tapimadi ve redakte etmek olmaz");
	}
	}
	
	@GetMapping(path = "/hamiya")
	public String test() {
		return "test";
	}
	
	@PreAuthorize(value = "hasAuthority('ROLE_GET_STUDENT')")
	@GetMapping(path = "/{id}")
	public StudentEntity finById(@PathVariable Integer id) {

		return studentDAO.findById(id).get();
	}
}
