package com.pms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pms.dto.ProductRequest;
import com.pms.dto.ProductResponse;
import com.pms.entity.Product;
import com.pms.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
/**
 * @author Naveen K  Wodeyar
 * @date 19-Jul-2024
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
	
	private final ProductRepository productRepository;
	
	public void createProduct(ProductRequest request) {
		Product product = Product.builder()
										.pName(request.getPName())
										.pDescription(request.getPDescription())
										.pPrice(request.getPPrice())
										.build();

		productRepository.save(product);
		log.info("Product {} saved successfully",product.getPId());
	}

	/**
	 * @apiNote, maps products to productResponse,
	 */
	public List<ProductResponse> getProducts() {
		List<Product> products = productRepository.findAll();
		
		List<ProductResponse> list = products.stream().map(product->ProductResponse.builder()
														.pId(product.getPId())
														.pName(product.getPName())
														.pDescription(product.getPDescription())
														.pPrice(product.getPPrice()).build()).toList();
		return list;
		
	}
}
