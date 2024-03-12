package az.developia.libraryelchinemirov.controller;
 
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import az.developia.libraryelchinemirov.entity.LibrarianEntity;
import az.developia.libraryelchinemirov.service.LibrarianService;

@RestController
@RequestMapping("/librarian") 
public class LibrarianRestController {
	@Autowired
	private LibrarianService librarianService;
	
	

	@PostMapping("/register/librarian")
    public void registerLibrarian(@Valid @RequestBody LibrarianEntity librarian) {
        librarianService.registerLibrarian(librarian);
    }

	@PostMapping("/borrow-Book") 
    public ResponseEntity<String> borrow_Book(@RequestParam Integer studentId, @RequestParam Integer bookId) {
      
            librarianService.borrowBook(studentId, bookId);
            return ResponseEntity.ok("Kitab ugurla verildi");

}
}