package com.pms.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Naveen K  Wodeyar
 * @date 19-Jul-2024
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {

	private String pName;
	private String pDescription;
	private BigDecimal pPrice;
}
