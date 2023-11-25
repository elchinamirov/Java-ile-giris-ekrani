package az.developia.springcore;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class SpringCoreApplicationTests {
	public static void main(String[] args) {
		
ConfigurableApplicationContext context =
SpringApplication.run(SpringCoreApplication.class, args);
String student = context.getBean(String.class);
System.out.println(student);

//String[] beans = context.getBeanDefinitionNames();
// for (String bean : beans) {
//	System.out.println(bean);
 }
}


	
	
