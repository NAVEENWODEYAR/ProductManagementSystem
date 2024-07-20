package com.pms.dto;
import java.math.BigDecimal;
/**
 * @author Naveen K Wodeyar
 * @date 19-Jul-2024
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItemsDto {

	private Long oltId;
	
	private String skuCode;
	
	private BigDecimal price;
	
	private Integer quantity;
}
