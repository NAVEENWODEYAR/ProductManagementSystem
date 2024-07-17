package com.product.service;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.dto.ProductRequest;
import com.product.dto.ProductResponse;
import com.product.entity.Product;
import com.product.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Naveen K Wodeyar
 * @date 17-Jul-2024
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

	private final ProductRepository productRepository;
	
	public void createProduct(ProductRequest request) {
		Product product = Product.builder()
							.name(request.getName())
							.description(request.getDescription())
							.price(request.getPrice())
							.build();
		productRepository.save(product);
		log.info("Product {} saved successfully",product.getId());;
	}

	/**
	 * @return
	 */
	public List<ProductResponse> getProducts() {
		List<Product> products = productRepository.findAll();
		 List<ProductResponse> list = products.stream().map(t -> ProductResponse.builder().id(t.getId()).description(t.getDescription()).price(t.getPrice()).name(t.getName()).build()).toList();
		return list;
	}
}
