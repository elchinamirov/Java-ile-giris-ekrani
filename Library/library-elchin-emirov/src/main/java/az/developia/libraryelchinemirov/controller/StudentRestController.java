package az.developia.libraryelchinemirov.controller;


import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import az.developia.libraryelchinemirov.dao.StudentDAO;
import az.developia.libraryelchinemirov.entity.StudentEntity;
import az.developia.libraryelchinemirov.exception.OurRuntimeException;
import az.developia.libraryelchinemirov.service.StudentService;



@RestController
@RequestMapping(path = "/students")
@CrossOrigin(origins="*")
public class StudentRestController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private StudentDAO studentDAO;
	
	@GetMapping
	@PreAuthorize(value = "hasAuthority('ROLE_GET_STUDENT')")
	public List<StudentEntity> showStudents() {
		return studentDAO.findAll();
	}
	
	@GetMapping(path = "/{id}")
	@PreAuthorize(value = "hasAuthority('ROLE_GET_STUDENT')")
	public StudentEntity findById(@PathVariable(name = "id") Integer id) {

		return studentDAO.findById(id).get();
	}
	

	@PostMapping
	@PreAuthorize(value = "hasAuthority('ROLE_ADD_STUDENT')")
	public ResponseEntity<StudentEntity> createStudent(@RequestBody StudentEntity s) {
		StudentEntity savedStudent = studentDAO.save(s);
		return ResponseEntity.ok(savedStudent);

	}

	@PutMapping
	@PreAuthorize(value = "hasAuthority('ROLE_UPDATE_STUDENT')")

	public void update(@javax.validation.Valid @RequestBody StudentEntity s) {
		studentService.update(s);
	}

	@DeleteMapping(path = "/delete/{id}")
	@PreAuthorize(value = "hasAuthority('ROLE_DELETE_STUDENT')")

	public void deletefunction(@PathVariable Integer id) {
		if (studentDAO.existsById(id)) {
			studentService.DeleteStudent(id);
		} else {
			throw new OurRuntimeException("sagird tapilmadi", null);
		}

	}
	
	
}