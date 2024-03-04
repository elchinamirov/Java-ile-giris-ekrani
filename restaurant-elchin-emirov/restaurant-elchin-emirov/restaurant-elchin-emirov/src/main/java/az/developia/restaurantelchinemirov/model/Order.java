package az.developia.restaurantelchinemirov.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class Order {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	private Long saleId;
	
	private Long productId;
	
	private Integer soldQuantity;

	public Long getSaleId() {
		return saleId;
	}

	public void setSaleId(Long saleId) {
		this.saleId = saleId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getSoldQuantity() {
		return soldQuantity;
	}

	public void setSoldQuantity(Integer soldQuantity) {
		this.soldQuantity = soldQuantity;
	}

	@Override
	public String toString() {
		return "Order [saleId=" + saleId + ", productId=" + productId + ", soldQuantity=" + soldQuantity + "]";
	}
	
	
	
	
}
