package az.developia.libraryelchinemirov.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import az.developia.libraryelchinemirov.dao.BookDAO;
import az.developia.libraryelchinemirov.entity.BookEntity;
import az.developia.libraryelchinemirov.exception.OurRuntimeException;

@Service
public class BookService {
	
	private BookEntity student;
	@Autowired
	private BookDAO bookDAO;

	public void add(BookEntity s, BindingResult br) {

		if (br.hasErrors()) {
			throw new OurRuntimeException("Melumatlarin tamligi pozulub", br);

		}
		s.setId(s.getId());
		s.setName(s.getName());
		s.setRegister(s.getRegister());
		bookDAO.save(s);
	}

	public void update(BookEntity s) {
		Optional<BookEntity> bookOptional =bookDAO.findById(s.getId());
		boolean bookExists = bookOptional.isPresent();
		BookEntity s1 = null;
		if (bookExists) {
			s1 = bookOptional.get();
			s1.setId(s1.getId());
			s1.setName(s1.getName());
			s1.setRegister(s1.getRegister());
			bookDAO.save(s1);
		} else {
			throw new OurRuntimeException("Kitab tapilmadi", null);
		}

	
		
}
	
	public String DeleteBook(Integer id) {
		bookDAO.deleteById(id);
		return "deleted" + id;
	}
	
}
