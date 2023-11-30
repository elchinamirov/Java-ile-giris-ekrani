package az.developia.springrest;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; // db
	private String name; // user
	private Double cost; // user
	private Double price; // user
	private String barcode; // user
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime register; // bar code
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public LocalDateTime getRegister() {
		return register;
	}
	public void setRegister(LocalDateTime register) {
		this.register = register;
	}
	public Product(Integer id, String name, Double cost, Double price, String barcode, LocalDateTime register) {
		super();
		System.out.println("ok");
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.price = price;
		this.barcode = barcode;
		this.register = register;
	}
public Product() {
}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", cost=" + cost + ", price=" + price + ", barcode=" + barcode
				+ ", register=" + register + "]";
	}
	
	
	

	
	

}
