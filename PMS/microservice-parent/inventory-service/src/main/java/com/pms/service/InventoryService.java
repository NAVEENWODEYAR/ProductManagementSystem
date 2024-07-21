package com.pms.service;

import com.pms.dto.InventoryResponse;
import lombok.SneakyThrows;
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

	@SneakyThrows
	@Transactional(readOnly = true)
	public List<InventoryResponse> isInStock(List<String> skuCode) {
		log.debug("Checking the stock,");
		log.info("Waiting for");
//		Thread.sleep(10000);
		log.info("Ready for");
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
