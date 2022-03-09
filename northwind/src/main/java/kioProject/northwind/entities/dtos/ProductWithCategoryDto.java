package kioProject.northwind.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@AllArgsConstructor
//@NoArgsConstructor
@Value
public class ProductWithCategoryDto {

	private int id;
	private String productName;
	private String CategoryName;

}
