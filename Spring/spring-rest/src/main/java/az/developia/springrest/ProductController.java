package az.developia.springrest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	product.setId(null);
	productRepository.save(product);
	
	//System.out.println(product);
}
@GetMapping
public List <Product> findAll(){
	
	return productRepository.findAll();
	}

@DeleteMapping(path="/{id}") //   /product/3
public String deleteById(@PathVariable Integer id) {
	
Optional<Product> finded = productRepository.findById(id);

 
if (finded.isPresent()) {
	
	productRepository.deleteById(id);
	return "Tapdim ve sildim";
	
}else {
	return "ID tapilmadi , id = "+id;

}
}

@PutMapping
public void update(@RequestBody Product product) {
	
	if (product.getId()==null || product.getId()<1) {
		throw new RuntimeException("ID bos ola ve ya movcud olmaya bilmez");
	}
	Optional<Product> finded = productRepository.findById(product.getId());

	if (finded.isPresent()) {
		
		productRepository.save(product);
		
	}else {
		throw new RuntimeException("ID tapilmadi ve redakte etmek olmaz");


	}
	
	
	
	
	
}



@ExceptionHandler
public String nese(RuntimeException e) {
	return e.getMessage();
}


}
