package az.developia.restaurantelchinemirov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.restaurantelchinemirov.dto.OrderSaleRequestDTO;
import az.developia.restaurantelchinemirov.dto.OrderSaleResponseDTO;
import az.developia.restaurantelchinemirov.exception.OurRuntimeException;
import az.developia.restaurantelchinemirov.model.Order;
import az.developia.restaurantelchinemirov.model.Product;

@Service
public class OrderService {
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private OrderDAO orderDAO;
	public OrderSaleResponseDTO sellProduct(OrderSaleRequestDTO o) {
		Product product=productDAO.findById(o.getProductId());
		
		if (product.getQuantity()<o.getQuantity()) {
			throw new OurRuntimeException("O sayda məhsul növcud deyil", null);
		}
		int updateQuantity=product.getQuantity() - o.getQuantity();
		product.setQuantity(updateQuantity);
		productDAO.save(product);
		
		Order order=new Order();
		order.setProductId(product.getId());
		order.setSoldQuantity(o.getQuantity());
		orderDAO.save(order);
		
		OrderSaleResponseDTO responseDTO=new OrderSaleResponseDTO();
		responseDTO.setSaleId(responseDTO.getSaleId());
		responseDTO.setProductId(product.getId());
		responseDTO.setSoldQuantity(o.getQuantity());
return responseDTO;
	}
	public void returnProduct(OrderSaleRequestDTO o) {
		Product product=productDAO.findById(o.getProductId());
		
		int updatedQuantity=product.getQuantity()+o.getQuantity();
		product.setQuantity(updatedQuantity);
		productDAO.save(product);
		Order order=new Order();
		order.setProductId(product.getId());
		order.setSoldQuantity(o.getQuantity());
		orderDAO.save(order);
	}

}
