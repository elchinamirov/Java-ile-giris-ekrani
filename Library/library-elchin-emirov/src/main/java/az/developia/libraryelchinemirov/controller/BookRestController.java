package az.developia.libraryelchinemirov.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

import az.developia.libraryelchinemirov.dao.BookDAO;
import az.developia.libraryelchinemirov.entity.BookEntity;
import az.developia.libraryelchinemirov.entity.LibrarianEntity;
import az.developia.libraryelchinemirov.exception.OurRuntimeException;
import az.developia.libraryelchinemirov.service.BookService;
import az.developia.libraryelchinemirov.service.LibrarianService;

@RestController
@RequestMapping(path = "/books")
@CrossOrigin(origins = "*")

public class BookRestController {
	@Autowired
	private BookDAO bookDAO;
	@Autowired
	private BookService bookService;
	@Autowired
	private LibrarianService librarianService;

	 @GetMapping
	 @PreAuthorize(value = "hasAnyRole('ROLE_LIBRARIAN','ROLE_STUDENT')")		
	    public List<BookEntity> getAllBooks() { //butun kitablari geri qaytarir
	        return bookService.getAllBooks();
	    }
	
	 @GetMapping("/{id}")
	 @PreAuthorize(value = "hasAnyRole('ROLE_LIBRARIAN','ROLE_STUDENT')")		
	 public ResponseEntity<BookEntity> getBookById(@PathVariable Long id) {
	        Optional<BookEntity> book = bookService.findById(id);
	        return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());  //kitablari geri qaytarir id-sine gore
	    }

	@PostMapping("/register")
	@PreAuthorize(value = "hasAuthority('ROLE_LIBRARIAN')")	
	public BookEntity registerBook(@RequestBody BookEntity book, @RequestParam Long librarianId) { 		//yeni kitab yaradir
		LibrarianEntity librarian = librarianService.findById(librarianId);
		return bookService.registerBook(book,librarian);
	}

	@GetMapping("/findByLibrarianId/{book_id}")		
	@PreAuthorize(value = "hasAuthority('ROLE_LIBRARIAN')")	
	
	public Page<BookEntity> getBooksByLibrarian(@RequestParam Long librarianId,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "1") int size) {
		LibrarianEntity librarian = librarianService.findById(librarianId);
		Pageable pageable = PageRequest.of(page, size);
		return bookService.getBooksByLibrarian(librarian, pageable);
	}

	@PutMapping("/{id}")
	@PreAuthorize(value = "hasAuthority('ROLE_LIBRARIAN')")	
	public BookEntity updateBook(@PathVariable("id") Long id, @RequestBody BookEntity updatedBook) {		//kitabi redakte edir
		return bookService.updateBook(id, updatedBook);
	}
	
	@DeleteMapping
	@PreAuthorize(value = "hasAuthority('ROLE_LIBRARIAN')")													//kitabi silir id-sine gore

	public void deletefunction(Long id) {
		if (bookDAO.existsById(id)) {
			bookService.DeleteBook(id);
		} else {
			throw new OurRuntimeException("kitab tapilmadi", null);
		}

	}
}