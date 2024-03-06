package az.developia.libraryelchinemirov.entity;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "books")
public class BookEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String name;
	private double price;
	private LocalDate register;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDate getRegister() {
		return register;
	}
	public void setRegister(LocalDate register) {
		this.register = register;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	

}
