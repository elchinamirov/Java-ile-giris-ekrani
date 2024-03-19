package az.developia.libraryelchinemirov.service;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.libraryelchinemirov.dao.BookDAO;
import az.developia.libraryelchinemirov.dao.BorrowedBookDAO;
import az.developia.libraryelchinemirov.dao.LibrarianDAO;
import az.developia.libraryelchinemirov.dao.StudentDAO;
import az.developia.libraryelchinemirov.dao.UserDAO;
import az.developia.libraryelchinemirov.entity.BookEntity;
import az.developia.libraryelchinemirov.entity.Borrowed;
import az.developia.libraryelchinemirov.entity.LibrarianEntity;
import az.developia.libraryelchinemirov.entity.StudentEntity;
import az.developia.libraryelchinemirov.entity.UserEntity;
import az.developia.libraryelchinemirov.exception.OurRuntimeException;

@Service
public class LibrarianService {
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private LibrarianDAO librarianRepository;
	@Autowired
	private BorrowedBookDAO borrowedBookRepository;
	@Autowired
	private BookDAO bookRepository;
	@Autowired 
	private StudentDAO studentRepository;
	
	
	public void registerLibrarian(LibrarianEntity librarian) {
        librarian.setPassword("{noop}" + librarian.getPassword());		
        librarianRepository.save(librarian);

        
        UserEntity user = new UserEntity();
        user.setUsername(librarian.getUsername());
       
        user.setEnabled(true); 
        user.setType("librarian");
        userDAO.addAdminAuthorities(user.getUsername());
        
        userDAO.save(user);
    }

	public LibrarianEntity findById(Long librarianId) {
		return librarianRepository.findById(librarianId)
				.orElseThrow(() -> new IllegalArgumentException("Kitabxanaci tapilmadi " + librarianId));	
	}
	
	
	 public void giveBook(Long studentId, Long bookId) {										
	        StudentEntity student = studentRepository.findById(studentId)
	                .orElseThrow(() -> new OurRuntimeException("Sagird tapilmadi",null));
	        BookEntity book = bookRepository.findById(bookId)
	                .orElseThrow(() -> new OurRuntimeException("Kitab tapilmadi",null));

	        
	        if (book.isAvailableForBorrowing()) {
	        	book.setTakeDate(LocalDateTime.now());
	            book.setAvailableForBorrowing(false);
	            
	            bookRepository.save(book);

	           
	            Borrowed takenBook = new Borrowed();
	            takenBook.setStudent(student);
	            takenBook.setBook(book);
	           
	            borrowedBookRepository.save(takenBook);
	        } else {
	            throw new OurRuntimeException("Kitab verilmek ucun uygun deyil",null);
	        }
	    }

	    

	    public List<Borrowed> getTakenBooksByStudent(Long studentId) {			
	        StudentEntity student = studentRepository.findById(studentId)
	                .orElseThrow(() -> new OurRuntimeException("Sagird tapilmadi",null));
	        return borrowedBookRepository.findByStudent(student);
	    }
	    
	    
}

