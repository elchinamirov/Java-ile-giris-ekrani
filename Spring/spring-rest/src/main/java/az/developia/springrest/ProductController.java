package az.developia.springrest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@PreAuthorize(value = "hasAuthority('ROLE_ADD_PRODUCT')") // 403 or 200
public void addProduct(@RequestBody Product product) {
	// add this object to database
	// id must be generated on db
	// register must config
	
	product.setRegister(LocalDateTime.now());
	product.setId(null);
	productRepository.save(product);
	
	//System.out.println(product);
}
@PreAuthorize(value = "hasAuthority('ROLE_GET_PRODUCT')") 
@GetMapping
public List <Product> findAll(){
	
	return productRepository.findAll();
	}

@DeleteMapping(path="/{id}") //   /product/3
@PreAuthorize(value = "hasAuthority('ROLE_DELETE_PRODUCT')") 

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
@PreAuthorize(value = "hasAuthority('ROLE_UPDATE_PRODUCT')") 

public void update(@RequestBody Product product) {
	
	if (product.getId()==null || product.getId()<1) {
		throw new OurRuntimeException("ID bos ola ve ya movcud olmaya bilmez");
	}
	Optional<Product> finded = productRepository.findById(product.getId());

	if (finded.isPresent()) {
		
		productRepository.save(product);
		
	}else {
		throw new OurRuntimeException("ID tapilmadi ve redakte etmek olmaz");
	}	
}

@GetMapping(path = "/barcode/{barcode}")   //Query
@PreAuthorize(value = "hasAuthority('ROLE_SEARCH_PRODUCT')") // 403 or 200

public  Product findByBarcode(@PathVariable String barcode){
	Product p = productRepository.findByBarcode(barcode);
	if (p==null) {
		throw new OurRuntimeException("Mehsul Tapilmadi");	
	}
	else {
           return p;
	} 

/*
 
@ExceptionHandler                                             .
public String handleOurRuntimeException(RuntimeException e) {
return e.getMessage();}


            Elverissiz oldugu ucun yeni class yaradildi
 
*/


}}




