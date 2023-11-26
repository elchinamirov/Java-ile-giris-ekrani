package az.developia.springcore;

import org.springframework.stereotype.Component;

@Component
public class Person {
	int id;
	String name;
    String adress;
    int salary;

    public Person() {
    	id=1234;
    	name="Elchin";
    	adress="Baku";
    	salary=2000;
    			
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
    
    
    
}
