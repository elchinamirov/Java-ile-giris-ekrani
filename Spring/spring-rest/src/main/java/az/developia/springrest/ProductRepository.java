package az.developia.springrest;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	
	Product findByBarcode(String barcode);//Query
		//{s*f pr where bac = }
	
	Product findByPrice(Double price);

	//findById var lakin biz digerlerine ozumuz qaydasiyla metod yaradiriq.

}
