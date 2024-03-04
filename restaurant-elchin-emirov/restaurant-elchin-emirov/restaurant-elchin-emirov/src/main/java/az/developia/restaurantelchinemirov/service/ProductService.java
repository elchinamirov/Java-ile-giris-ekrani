package az.developia.restaurantelchinemirov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import az.developia.restaurantelchinemirov.dao.ProductDAO;
import az.developia.restaurantelchinemirov.exception.OurRuntimeException;
import az.developia.restaurantelchinemirov.model.Product;
@Service
public class ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	public void add(Product p, BindingResult br) {
		if (br.hasErrors()) {
			throw new OurRuntimeException("Məlumatların tamlığı pozulub", br);
			
		}
		p.setId(p.getId());
		p.setName(p.getName());
		p.setQuantity(p.getQuantity());
        
		productDAO.save(p);
	}
	
	public void update (Product) {
		
	}
}
