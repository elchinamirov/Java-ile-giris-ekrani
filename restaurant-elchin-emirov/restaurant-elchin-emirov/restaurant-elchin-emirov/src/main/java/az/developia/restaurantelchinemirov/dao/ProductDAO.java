package az.developia.restaurantelchinemirov.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.restaurantelchinemirov.model.Product;

public interface ProductDAO extends JpaRepository<Product, Integer> {
	Product findByBarcode(String barcode) ;
	Product findByPrice(Double price);
}
