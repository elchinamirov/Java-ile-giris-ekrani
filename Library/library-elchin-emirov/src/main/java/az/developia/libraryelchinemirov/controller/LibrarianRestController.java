package az.developia.libraryelchinemirov.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
@CrossOrigin(origins = "*")
public class LibrarianRestController {
	@Autowired
	private  LibrarianService librarianService;
	
	@PostMapping("/register/librarian")			
	@PreAuthorize(value = "hasAuthority('ROLE_LIBRARIAN')")	
	//kitabxanaci register etmek 
    public void registerLibrarian(@Valid @RequestBody LibrarianEntity librarian) {
        librarianService.registerLibrarian(librarian);
    }
	
	@PostMapping("/giveBook")
	@PreAuthorize(value = "hasAuthority('ROLE_LIBRARIAN')")	
    public ResponseEntity<String> giveBook(@RequestParam Long studentId, @RequestParam Long bookId) {	//sagirde kitab vermek 
      
            librarianService.giveBook(studentId, bookId);
            return ResponseEntity.ok("Kitab ugurla verildi");
     
    }

   
}