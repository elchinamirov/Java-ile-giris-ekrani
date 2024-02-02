package az.developia.restaurantelchinemirov.controller;

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

import az.developia.restaurantelchinemirov.model.Product;

@RestController

@RequestMapping(path = "/products")

public class ProductController {

	@PostMapping
	public void addProduct(@RequestBody Product product) {
		        // add this obj to db
				// id must be generated on db
				// register must be config

				product.setRegister(LocalDateTime.now());

				System.out.println(product);

			}

			@GetMapping
			public List<Product> findAll() {

				List<Product> products = new ArrayList<>();
				products.add(new Product(2, "Alma",  7D, "002", LocalDateTime.of(2020, 3, 15, 11, 15, 0)));
				products.add(new Product(5, "Alca",  7D, "003", LocalDateTime.of(2020, 3, 15, 11, 15, 0)));
				products.add(new Product(6, "Nar",  7D, "004", LocalDateTime.of(2020, 3, 15, 11, 15, 0)));
				products.add(new Product(6, "Nar",  7D, "004", LocalDateTime.of(2020, 3, 15, 11, 15, 0)));

				return products;
			}

			//
			@DeleteMapping(path = "/{id}") // /products/3
			public void deleteById(@PathVariable Integer id) {

				System.out.println(id);
			}

		}
	
