package az.developia.restaurantelchinemirov.model;

	import java.time.LocalDateTime;

	import com.fasterxml.jackson.annotation.JsonFormat;

	 
	public class Product {
		 
		private Integer id;// db
		private String name;// user
		
		private Double price;// user
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
		public Product(Integer id, String name, Double price, String barcode, LocalDateTime register) {
			super();
			this.id = id;
			this.name = name;
			this.price = price;
			this.barcode = barcode;
			this.register = register;
		}
		@Override
		public String toString() {
			return "Product [id=" + id + ", name=" + name + ", price=" + price + ", barcode=" + barcode
					+ ", register=" + register + "]";
		
		}
}
