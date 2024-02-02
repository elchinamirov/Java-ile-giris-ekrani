package az.developia.restaurantelchinemirov.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.restaurantelchinemirov.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
