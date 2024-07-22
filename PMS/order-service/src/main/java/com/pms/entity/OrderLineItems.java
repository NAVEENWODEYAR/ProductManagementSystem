package com.pms.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Naveen K Wodeyar
 * @date 19-Jul-2024
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_ORDER_LINE_ITEMS")
public class OrderLineItems {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oltId;
		
	private String skuCode;
	
	private BigDecimal price;
	
	private Integer quantity;
	
	

}
