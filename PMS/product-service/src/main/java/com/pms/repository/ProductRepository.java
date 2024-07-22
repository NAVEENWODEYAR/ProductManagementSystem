package com.pms.repository;
/**
 * @author Naveen K  Wodeyar
 * @date 19-Jul-2024
 */
import org.springframework.data.mongodb.repository.MongoRepository;

import com.pms.entity.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
