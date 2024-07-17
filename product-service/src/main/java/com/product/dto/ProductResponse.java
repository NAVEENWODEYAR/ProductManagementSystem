package com.product.dto;
/**
 * @author Naveen K Wodeyar
 * @date 17-Jul-2024
 */
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {

	private String id;
	private String name;
	private String description;
	private BigDecimal price;
}
