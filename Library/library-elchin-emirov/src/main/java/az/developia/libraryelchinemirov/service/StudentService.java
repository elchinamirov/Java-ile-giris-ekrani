package az.developia.libraryelchinemirov.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.libraryelchinemirov.dao.BookDAO;
import az.developia.libraryelchinemirov.dao.BorrowedBookDAO;
import az.developia.libraryelchinemirov.dao.StudentDAO;
import az.developia.libraryelchinemirov.dao.UserDAO;
import az.developia.libraryelchinemirov.entity.BookEntity;
import az.developia.libraryelchinemirov.entity.Borrowed;
import az.developia.libraryelchinemirov.entity.StudentEntity;
import az.developia.libraryelchinemirov.entity.UserEntity;
import az.developia.libraryelchinemirov.exception.OurRuntimeException;

@Service
public class StudentService {

	
	@Autowired
	private StudentDAO studentDAO;
	
	@Autowired
	private UserDAO userDAO;

	@Autowired
	private BorrowedBookDAO borrowedBookRepository;
	@Autowired
	private BookDAO bookDAO;
	
	
	
	
	public void update(StudentEntity s) {			
		Optional<StudentEntity> studentOptional = studentDAO.findById(s.getId());
		boolean studentExists = studentOptional.isPresent();
		StudentEntity s1 = null;
		if (studentExists) {
			s1 = studentOptional.get();
			s1.setId(s.getId());
			s1.setAddress(s.getAddress());
			s1.setPhone(s.getPhone());
			s1.setName(s.getName());
			s1.setSurname(s.getSurname());
			studentDAO.save(s1);
		} else {
			throw new OurRuntimeException("sagird tapilmadi", null);
		}

	}

	public String DeleteStudent(Long id) {
		studentDAO.deleteById(id);									
		return "deleted" + id;
	}

	
	public void registerStudent(StudentEntity student) {			
        student.setPassword("{noop}" + student.getPassword());
        studentDAO.save(student);

        
        UserEntity user = new UserEntity();
        user.setUsername(student.getUsername());
        user.setPassword(student.getPassword()); 
        user.setType("student");
        user.setEnabled(true); 
        
        userDAO.addUserAuthorities(user.getUsername());
        
        userDAO.save(user);
    }
	
	public List<Borrowed> getBooksTakenByStudent(Long studentId) {
        return borrowedBookRepository.findByStudentId(studentId);				
    }

    public void returnBook(Long takenBookId) {														
        Borrowed takenBook = borrowedBookRepository.findById(takenBookId)
                .orElseThrow(() -> new OurRuntimeException("Taken book not found",null));

        BookEntity book = takenBook.getBook();
        book.setAvailableForBorrowing(true);
        book.setReturnDate(LocalDateTime.now());
        bookDAO.save(book);

       
        borrowedBookRepository.delete(takenBook);
        
        
        
        
    }

}
