package az.developia.springcore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MyConfig {

	@Bean
	//@Primary
	
	public Student myStudent() {
		
	Student s = new Student();
	s.setName("Ceyhun");
	s.setSurname("Amirov");
	return s;
	

	}
	@Bean
	@Primary
	
	public Computer myComputer() {
		
	Computer s = new Computer("Pavilion" , 2000);
	
	return s;
	

	}}
