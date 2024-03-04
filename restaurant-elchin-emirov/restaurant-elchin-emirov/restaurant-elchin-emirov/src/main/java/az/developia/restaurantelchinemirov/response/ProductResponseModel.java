package az.developia.restaurantelchinemirov.response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import az.developia.restaurantelchinemirov.dto.ProductDTO;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ProductResponseModel {

private List<ProductDTO>products;
private LocalDateTime now;
}
