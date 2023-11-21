package az.developia.springcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringCoreApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = 
				SpringApplication.run(SpringCoreApplication.class, args);
	Student student = context.getBean(Student.class);
	System.out.println(student.getName());
	
	String[] beans = context.getBeanDefinitionNames();
	for (String bean : beans) {
		System.out.println(bean);
	}
	}
	} 

