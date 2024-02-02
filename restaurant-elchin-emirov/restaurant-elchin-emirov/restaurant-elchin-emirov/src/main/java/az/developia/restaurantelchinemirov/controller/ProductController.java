package az.developia.restaurantelchinemirov.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import az.developia.restaurantelchinemirov.exception.OurRuntimeException;

import az.developia.restaurantelchinemirov.model.Product;
import az.developia.restaurantelchinemirov.repository.ProductRepository;

@RestController

@RequestMapping(path = "/products")

public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;


	@PostMapping
	public void addProduct(@RequestBody Product product) {
		        // add this obj to db
				// id must be generated on db
				// register must be config

				product.setRegister(LocalDateTime.now());
				product.setId(null);

				productRepository.save(product);
				
				// System.out.println(product);

			}

			@GetMapping
			public List<Product> findAll() {

				return productRepository.findAll();
			}

			//
			
			
@DeleteMapping(path = "/{id}")
public String deleteById(@PathVariable Integer id) {
	Optional<Product> finded = productRepository.findById(id);

	if (finded.isPresent()) {

		productRepository.deleteById(id);
		return "tapdin ve sildim";
	} else {
		return "id tapilmadi, id = " + id;
	}

}

@PutMapping
public void update(@RequestBody Product product) {
	
	if (product.getId() == null || product.getId() < 1) {
		throw new OurRuntimeException("id bos veya olmayan ola bilmez");
	}

	Optional<Product> finded = productRepository.findById(product.getId());

	if (finded.isPresent()) {
		productRepository.save(product);
	} else {
		throw new OurRuntimeException("id tapimadi ve redakte etmek olmaz");
	}

}
@GetMapping(path="/barcode/{barcode}")
public  Product findByBarcode(@PathVariable String barcode) {
	Product p = productRepository.findByBarcode(barcode);
	if(p==null) {
		throw new OurRuntimeException("mehsul tapilmadi");
	}
	else {
		return p;
	}
	
}}
	
