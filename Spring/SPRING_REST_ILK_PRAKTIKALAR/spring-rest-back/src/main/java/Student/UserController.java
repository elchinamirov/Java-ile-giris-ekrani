package Student;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController

@RequestMapping(path = "/users")
@CrossOrigin(origins = "*")
public class UserController {
	
	@GetMapping(path = "/login")
	public void login() {
		
	}

}
