package az.developia.restaurantelchinemirov.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFilter;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

@JsonFilter(value = "product")
public class ProductDTO {
 private Integer id;
 private String name;
 private Double cost;
 private Double price; 
 
 private LocalDateTime register; // bar code
	
}
