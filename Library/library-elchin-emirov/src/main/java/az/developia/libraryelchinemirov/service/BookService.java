package az.developia.libraryelchinemirov.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import az.developia.libraryelchinemirov.dao.BookDAO;
import az.developia.libraryelchinemirov.entity.BookEntity;
import az.developia.libraryelchinemirov.entity.LibrarianEntity;
import az.developia.libraryelchinemirov.exception.OurRuntimeException;
@Service
public class BookService {
	
	@Autowired
	private BookDAO bookDAO;

	
	 public List<BookEntity> getAllBooks() {		
	        return bookDAO.findAll();
	    }
	public BookEntity registerBook(BookEntity book,LibrarianEntity librarian) {			
			book.setLibrarian(librarian);
			book.setAvailableForBorrowing(true);
			return bookDAO.save(book);
	}
	 public Optional<BookEntity> findById(Long id) {	
	        return bookDAO.findById(id);
	    }

	public String DeleteBook(Long id) {						
		bookDAO.deleteById(id);
		return "deleted" + id;
	}
	public BookEntity updateBook(@PathVariable Long id, BookEntity updatedBook) {
		Optional<BookEntity> optionalBook = bookDAO.findById(id);
		if (optionalBook.isPresent()) {															
			BookEntity existingBook = optionalBook.get();
			existingBook.setPrice(updatedBook.getPrice());
			existingBook.setName(updatedBook.getName());
			existingBook.setPublicationDate(updatedBook.getPublicationDate());
			return bookDAO.save(existingBook);
		} else {
			throw new OurRuntimeException("Bu ID ile olan kitab " + id + " tapilmadi", null);
		}
	}
	public Page<BookEntity> getBooksByLibrarian(LibrarianEntity librarian, Pageable pageable) {		
		return bookDAO.findByLibrarian(librarian, pageable);
	}
}
