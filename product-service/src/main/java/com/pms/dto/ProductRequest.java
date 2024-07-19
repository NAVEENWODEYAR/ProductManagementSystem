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
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Builder
public class ProductRequest {

	private String pName;
	private String pDescription;
	private BigDecimal pPrice;
	/**
	 * @return the pName
	 */
	public String getpName() {
		return pName;
	}
	/**
	 * @param pName the pName to set
	 */
	public void setpName(String pName) {
		this.pName = pName;
	}
	/**
	 * @return the pDescription
	 */
	public String getpDescription() {
		return pDescription;
	}
	/**
	 * @param pDescription the pDescription to set
	 */
	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}
	/**
	 * @return the pPrice
	 */
	public BigDecimal getpPrice() {
		return pPrice;
	}
	/**
	 * @param pPrice the pPrice to set
	 */
	public void setpPrice(BigDecimal pPrice) {
		this.pPrice = pPrice;
	}
	/**
	 * @param pName
	 * @param pDescription
	 * @param pPrice
	 */
	public ProductRequest(String pName, String pDescription, BigDecimal pPrice) {
		super();
		this.pName = pName;
		this.pDescription = pDescription;
		this.pPrice = pPrice;
	}
	
	public ProductRequest() {}
}
