package com.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.service.InventoryService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Naveen K Wodeyar
 * @date19-Jul-2024
 */
@RestController
@RequestMapping("/api/inventory")
@Slf4j
public class InventoryController {
	
	@Autowired
	private InventoryService inventoryService;

	@GetMapping("/test")
	public ResponseEntity<?> test(){
		log.warn("Test Endpoint");
		return ResponseEntity.status(HttpStatus.ACCEPTED)
								.header("Header", "Test")
								.body("Welcome to Inventory\nService!,");
	}
	
	@GetMapping("/{skuCode}")
	public Boolean isInStock(@PathVariable("skuCode") String skuCode) {
		return inventoryService.isInStock(skuCode);
	}
}
