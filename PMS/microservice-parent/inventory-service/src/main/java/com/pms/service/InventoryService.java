package com.pms.service;

import com.pms.dto.InventoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pms.repository.InventoryRepository;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author Naveen K Wodeyar
 * @date19-Jul-2024
 */
@Service
@Slf4j
public class InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;
	
	@Transactional(readOnly = true)
	public List<InventoryResponse> isInStock(List<String> skuCode) {
		log.debug("Checking the stock,");
		 return inventoryRepository.findBySkuCodeIn(skuCode)
				 .stream()
				 .map(inventory ->
					 InventoryResponse.builder()
							 .skuCode(inventory.getSkuCode())
							 .isInStock(inventory.getQuantity() > 0)
							 .build()
				 ).toList();
	}
}
