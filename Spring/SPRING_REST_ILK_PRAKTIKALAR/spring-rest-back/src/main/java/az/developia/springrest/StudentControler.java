 package az.developia.springrest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentControler {
	
	@GetMapping(path = "/student-object")
	public Student showMeSomeStudents() {
		Student s=new Student("Elchin", "Amirov", "Aghdam", 05555555555) ;
		return s;
}
}