package az.developia.restaurantelchinemirov.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

				productRepository.save(product);
				
				// System.out.println(product);

			}

			@GetMapping
			public List<Product> findAll() {

				return productRepository.findAll();
			}

			//
			@DeleteMapping(path = "/{id}") // /products/3
			public void deleteById(@PathVariable Integer id) {

				System.out.println(id);
			}

		}
	
