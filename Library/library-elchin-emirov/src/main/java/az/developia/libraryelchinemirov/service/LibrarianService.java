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
	private LibrarianDAO librarianDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private BorrowedBookDAO borrowedBookDAO;
	@Autowired
	private BookDAO bookDAO;
	@Autowired 
	private StudentDAO studentDAO;
	
	 	


	public void registerLibrarian(LibrarianEntity librarian) {
        librarian.setPassword("{noop}" + librarian.getPassword());
        librarianDAO.save(librarian);

        
        UserEntity user = new UserEntity();
        user.setUsername(librarian.getUsername());
        user.setEnabled(true); 

        user.setType("librarian");
        userDAO.addAdminAuthorities(user.getUsername());
        userDAO.save(user);
    }

	public LibrarianEntity findById(Integer librarianId) {
		return librarianDAO.findById(librarianId)
		.orElseThrow(() -> new IllegalArgumentException("Bele bir id-le Librarian yoxdur: " + librarianId));
	}
	 public void borrowBook(Integer studentId, Integer bookId) {
	        StudentEntity student = studentDAO.findById(studentId)
	                .orElseThrow(() -> new OurRuntimeException("Sagird tapilmadi",null));
	        BookEntity book = bookDAO.findById(bookId)
	                .orElseThrow(() -> new OurRuntimeException("Kitab tapilmadi",null));

	        
	        if (book.isAvailableForBorrowing()) {
	           book.setBorrowedDate(LocalDateTime.now());
	            book.setAvailableForBorrowing(false);
	            
	            bookDAO.save(book);

	           
	            Borrowed borrowed = new Borrowed();
	            borrowed.setStudentid(student);
	            borrowed.setBook(book);
	            borrowedBookDAO.save(borrowed);
	        } else {
	            throw new OurRuntimeException("Kitab verilmek ucun uygun deyil",null);
	        }
	    }

	    public List<Borrowed> getBorrowedBooksByStudent(Integer studentId) {
	        StudentEntity student = studentDAO.findById(studentId)
	                .orElseThrow(() -> new OurRuntimeException("Sagird tapilmadi",null));
	        return borrowedBookDAO.findByStudent(student);
	    }
}


