package az.developia.springrest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/products")
public class ProductController {
@PostMapping
public void addProduct(@RequestBody Product product) {
	// add this object to database
	// id must be generated on db
	// register must config
	
	product.setRegister(LocalDateTime.now());
	System.out.println(product);
}
@GetMapping
public List <Product> findAll(){
	List<Product> products=new ArrayList<Product>();
	products.add(new Product(2, "Alma", 3D, 7D, "002", LocalDateTime.of(2020, 3, 15, 11, 15,0)));
	products.add(new Product(5, "Alca", 5D, 7D, "003", LocalDateTime.of(2020, 3, 15, 11, 15,0)));
	products.add(new Product(6, "Nar", 3D, 7D, "004", LocalDateTime.of(2020, 3, 15, 11, 15,0)));
	products.add(new Product(6, "Nar", 3D, 7D, "004", LocalDateTime.of(2020, 3, 15, 11, 15,0)));

	return products;
	}
@DeleteMapping(path="/{id}") //   /product/3
public void deleteById(@PathVariable Integer id) {
	
	System.out.println(id);
	
}
}
