package com.pms.entity;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Naveen K  Wodeyar
 * @date 19-Jul-2024
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "product")
public class Product {
	
	@Id
	private String pId;
	private String pName;
	private String pDescription;
	private BigDecimal pPrice;
	

}
