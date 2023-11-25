 package az.developia.springrest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentControler {
	@GetMapping(path = "/students")
	public List<String> showMeSomeStudents(){
		List<String>  list= new ArrayList<>();
		list.add("Elchin");
		list.add("Ceyhun");
		list.add("John");
		return list;
		
	}
	@GetMapping(path = "/student")
	public List<String> showMeSomeStudent(){
		List<String>  list= new ArrayList<>();
		list.add("Elchin");
		
		return list;
		
	

}
}