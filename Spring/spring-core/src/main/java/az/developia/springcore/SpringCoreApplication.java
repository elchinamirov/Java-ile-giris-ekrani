package az.developia.springcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringCoreApplication {

	private static String[] String;

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringCoreApplication.class, args);
		
		//Computer computer = context.getBean(Computer.class);
		//	System.out.println(computer.getBrand());
		
		}
		
	
}


	


