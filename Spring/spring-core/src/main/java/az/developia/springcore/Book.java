package az.developia.springcore;

import org.springframework.stereotype.Component;

@Component
public class Book {
	
	
		
	
	
	private int id;
	private String name;
	private int price;
	private int pageCount;
	
	
	public Book() {
		
	 id=1234;
	 name="Elchin";
	 price=20;
	 pageCount=166;
	
	

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


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getPageCount() {
		return pageCount;
	}


	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
}