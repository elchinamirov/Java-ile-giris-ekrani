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

import az.developia.libraryelchinemirov.dao.BookDAO;
import az.developia.libraryelchinemirov.entity.BookEntity;
import az.developia.libraryelchinemirov.exception.OurRuntimeException;
import az.developia.libraryelchinemirov.service.BookService;

@RestController
@RequestMapping(path = "/books")
@CrossOrigin(origins="*")
public class BookRestController {
	@Autowired
	private BookService bookService;
	@Autowired
	private BookDAO bookDAO;
	
	@GetMapping
	@PreAuthorize(value = "hasAuthority('ROLE_GET_BOOK')")
	public List<BookEntity> showBooks() {
		return bookDAO.findAll();
	}
	
	@GetMapping(path = "/{id}")
	@PreAuthorize(value = "hasAuthority('ROLE_GET_BOOK')")
	public BookEntity findById(@PathVariable(name = "id") Integer id) {

		return bookDAO.findById(id).get();
	}
	
	
	@PostMapping
	@PreAuthorize(value = "hasAuthority('ROLE_ADD_BOOK')")
	public ResponseEntity<BookEntity> createBook(@RequestBody BookEntity b) {
		BookEntity savedBook = bookDAO.save(b);
		return ResponseEntity.ok(savedBook);

	}

	@PutMapping
	@PreAuthorize(value = "hasAuthority('ROLE_UPDATE_BOOK')")

	public void update(@javax.validation.Valid @RequestBody BookEntity b) {
		bookService.update(b);
	}

	@DeleteMapping(path = "/delete/{id}")
	@PreAuthorize(value = "hasAuthority('ROLE_DELETE_BOOK')")

	public void deletefunction(@PathVariable Integer id) {
		if (bookDAO.existsById(id)) {
			bookService.DeleteBook(id);
		} else {
			throw new OurRuntimeException("kitab tapilmadi", null);
		}

	}
	
}