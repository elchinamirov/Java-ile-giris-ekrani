package az.developia.bookshopping.cotroller;

import java.util.ArrayList;
import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import az.developia.bookshopping.config.MySession;
import az.developia.bookshopping.dao.BookDAO;
import az.developia.bookshopping.model.Book;
import ch.qos.logback.core.joran.conditional.IfAction;


@Controller
public class CustomerController {

	@Autowired
	private BookDAO bookDAO;	
	
	
	@Autowired
	private MySession mySession;
	
		@GetMapping(path = "/customer")
		public String showCustomerPage (Model model) {
			List<Book> books=bookDAO.findAll();
			model.addAttribute("books", books);
			System.out.println(mySession.getUsername());
            return "customer";
			
		}
		
		}


















