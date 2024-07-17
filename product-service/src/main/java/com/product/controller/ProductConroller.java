package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.product.dto.ProductRequest;
import com.product.dto.ProductResponse;
import com.product.service.ProductService;

/**
 * @author Naveen K Wodeyar
 * @date 17-Jul-2024
 */
@RestController
@RequestMapping("/api/product")
public class ProductConroller {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/test")
	public ResponseEntity<?> greet(){
		return ResponseEntity.ok("Welcome to \nPRODUCT\nSERVICE");
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createProduct(@RequestBody ProductRequest request) {
		productService.createProduct(request);
	}
	
	@GetMapping
	public List<ProductResponse> getProducts(){
		return productService.getProducts();
	}
}
