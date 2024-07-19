package com.pms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pms.repository.InventoryRepository;

import lombok.extern.slf4j.Slf4j;

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
	public Boolean isInStock(String skuCode) {
		log.debug("Checking the stock,");
		 return inventoryRepository.findBySkuCode(skuCode).isPresent();
	}
}
