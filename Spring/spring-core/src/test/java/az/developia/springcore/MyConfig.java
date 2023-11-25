package az.developia.springcore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

	//@Bean(name="tam")
	public Student myStudent() {
		
	Student s = new Student();
	s.setName("Elchin");
	s.setSurname("Amirov");
	return s;
	

	}

}
