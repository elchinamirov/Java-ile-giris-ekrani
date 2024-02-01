package az.developia.bookshopping.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping(path = {"/home","/"})
	public String showHomePage() {
		return "home";
	}
	
		
	
	

}
