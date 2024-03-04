package az.developia.restaurantelchinemirov.model;

	import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.fasterxml.jackson.annotation.JsonFormat;
	@javax.persistence.Entity
	@javax.persistence.Table(name="products")
	public class Product {
		 
		@javax.persistence.Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		
		private Integer id;// db
		private String name;// user
		private Integer quantity;
		private Double price;// user
		@Column(unique = true)

		private String barcode; // user
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
		
		public Integer getQuantity() {
			return quantity;
		}
		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}
		public Product(Integer id, String name,Integer quantity ,Double price, String barcode, LocalDateTime register) {
			super();
			System.out.println("ok");
			this.id = id;
			this.name = name;
			this.price = price;
			this.barcode = barcode;
			this.register = register;
			this.quantity=quantity;
		}
		@Override
		public String toString() {
			return "Product [id=" + id + ", name=" + name + ", quantity=" + quantity + ", price=" + price + ", barcode=" + barcode
					+ ", register=" + register + "]";
		
		}
	
		public Product() {
			// TODO Auto-generated constructor stub
		}
}
