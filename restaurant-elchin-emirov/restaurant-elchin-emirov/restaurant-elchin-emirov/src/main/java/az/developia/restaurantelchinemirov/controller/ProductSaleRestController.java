package az.developia.restaurantelchinemirov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.restaurantelchinemirov.dto.OrderSaleRequestDTO;
import az.developia.restaurantelchinemirov.dto.OrderSaleResponseDTO;
import az.developia.restaurantelchinemirov.service.OrderService;

@RestController
@RequestMapping("/api/sales")
public class ProductSaleRestController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/sell")
public ResponseEntity<OrderSaleResponseDTO> sellProduct(@RequestBody OrderSaleRequestDTO saleRequestDTO){
		OrderSaleResponseDTO saleResponseDTO=orderService.sellProduct(saleRequestDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(saleResponse);
		
	}
	@PostMapping("/return")
	public ResponseEntity<String> returnProduct(@RequestBody OrderSaleRequestDTO returnRequestDTO){
			orderService.returnProduct(returnRequestDTO);
			return ResponseEntity.ok("Product returned succesfully");
			
		}
}
