package com.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.dto.ProductRequest;
import com.pms.dto.ProductResponse;
import com.pms.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Naveen K  Wodeyar
 * @date 19-Jul-2024
 */
@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/product")
public class ProductController {
	@Autowired
	private  ProductService productService;

    @GetMapping("/test")
	public ResponseEntity<?> test(){

		log.warn("TestEndpoint accessed,");
		return ResponseEntity.status(HttpStatus.FOUND)
							 .header("TestEndpoint", "application/json")
							 .body("Welcome to Product Service,");
	}
	
	@PostMapping
	public void createProduct(@RequestBody ProductRequest request) {
		log.info("Product {} crated successfully",request.getpName());
		productService.createProduct(request);
	}
	
	@PostMapping("/add")
    public void createProducts(@RequestBody ProductRequest request) {
        log.info("Product {} created successfully", request.getpName());
        productService.createProduct(request);
    }
	
	
	@GetMapping
	public List<ProductResponse> getProducts(){
		log.warn("Products");
		return productService.getProducts();
	}
}
