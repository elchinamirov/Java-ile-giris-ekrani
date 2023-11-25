package az.developia.springcore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;

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
	

	}

	@Bean
	public Computer myComputer2() {
		
	Computer s = new Computer("x5" , 4000);
	
	return s;
		
}
	@Bean
	
	public String s1() {
		System.out.println("s1");
		return"ok";	}
}