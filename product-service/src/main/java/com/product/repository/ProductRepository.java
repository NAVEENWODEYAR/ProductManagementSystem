package com.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.product.entity.Product;

/**
 * @author Naveen K Wodeyar
 * @date 17-Jul-2024
 */
public interface ProductRepository extends MongoRepository<Product, String> {

}
