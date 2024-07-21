package com.pms.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pms.dto.OrderRequest;
import com.pms.service.OrderService;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

/**
 * @author Naveen K Wodeyar
 * @date 19-Jul-2024
 */
@Slf4j
@RestController
@RequestMapping("/api/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/test")
	public ResponseEntity<?> test(){
		log.info("test endPoint");
		return ResponseEntity.status(HttpStatus.FOUND)
							.header("Heder", "Test/EndPoint")
							.body("Welcome to the Order application,");
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@CircuitBreaker(name = "inventory",fallbackMethod = "fallbackMethod")
	@TimeLimiter(name = "inventory")
	@Retry(name = "inventory")
	public CompletableFuture<String> placeOrder(@RequestBody OrderRequest request) {
		log.warn("Order {} placed successfully",request.getOrderLineItemsDtoList().get(0).getOltId());
		return CompletableFuture.supplyAsync(()->orderService.placeOrder(request) );
	}

	public CompletableFuture<String> fallbackMethod(OrderRequest request,RuntimeException runtimeException){
		return CompletableFuture.supplyAsync(()->"Internal application error, Please try after sometime!, ");
	}
}
