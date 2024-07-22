package com.pms.dto;
/**
 * @author Naveen K  Wodeyar
 * @date 19-Jul-2024
 */
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {

	private String pId;
	private String pName;
	private String pDescription;
	private BigDecimal pPrice;
}
