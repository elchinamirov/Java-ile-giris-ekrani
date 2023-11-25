package az.developia.springcore;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class SpringCoreApplicationTests {
	public static void main(String[] args) {
		
ConfigurableApplicationContext context =
SpringApplication.run(SpringCoreApplication.class, args);
Student student = context.getBean(Student.class);
System.out.println(student.getName());
System.out.println(student.getComputer());

//String[] beans = context.getBeanDefinitionNames();
// for (String bean : beans) {
//	System.out.println(bean);
 }
}


	
	
