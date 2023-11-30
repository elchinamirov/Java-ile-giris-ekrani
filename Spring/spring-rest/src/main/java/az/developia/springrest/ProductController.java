package az.developia.springrest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	private ProductRepository productRepository;
	
	
@PostMapping
public void addProduct(@RequestBody Product product) {
	// add this object to database
	// id must be generated on db
	// register must config
	
	product.setRegister(LocalDateTime.now());
	
	productRepository.save(product);
	
	//System.out.println(product);
}
@GetMapping
public List <Product> findAll(){
	
	return productRepository.findAll();
	}
@DeleteMapping(path="/{id}") //   /product/3
public void deleteById(@PathVariable Integer id) {
	
	System.out.println(id);
	
}
}
