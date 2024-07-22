package com.pms.controller;

import com.pms.dto.InventoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pms.service.InventoryService;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

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
	
	@GetMapping
	public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode) {
		return inventoryService.isInStock(skuCode);
	}
}
