package az.developia.bookshopping.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import az.developia.bookshopping.dao.BookDAO;
import az.developia.bookshopping.model.Book;
import ch.qos.logback.core.joran.conditional.IfAction;


@Controller
public class BookController {

		@Autowired
		private BookDAO bookDAO;
		
		@GetMapping(path = "/books")
		public String showBooks (Model model) {
			List<Book> books=bookDAO.findAll();
						 model.addAttribute("books", books);
                        return "books";
			
		}
		@GetMapping(path = "/books/new")
		public String openNewBookPage (Model model) {
			Book book=new Book();
			model.addAttribute("book", book);
                        return "new-book";
			
		}
		
		
		
		@PostMapping(path = "/books/new-book-process")
		public String saveBook(@ModelAttribute(name="book") Book book,Model model) {
			
			book.setImage("book.jpg");
            bookDAO.save(book);
			book.setUsername("elchin");

            
			List<Book> books= bookDAO.findAll();
			model.addAttribute("books", books);
			
			return "books";
			
		}
		@GetMapping(path = "/books/delete/{id}")
		public String deleteBook (@PathVariable(name="id") Integer id, Model model) {
			boolean bookExists=bookDAO.findById(id).isPresent();
			if (bookExists) {
				
						bookDAO.deleteById(id);
			}else {
				
			}
			
			List<Book> books= bookDAO.findAll();
				model.addAttribute("books", books);
				
                        return "redirect:/books";
			
		}
		}


















