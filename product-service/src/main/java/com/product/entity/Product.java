package com.product.entity;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

/**
 * @author Naveen K Wodeyar
 * @date 17-Jul-2024
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "product")
@Builder
public class Product {

	@Id
	private String id;
	
	private String name;
	
	private String description;
	
	private BigDecimal price;
	
	
}
