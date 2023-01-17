package com.gt.product.domain.repo;

import com.gt.product.domain.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductRepo extends MongoRepository<Product,String> {
    Optional<Product> findByName(String skuCode);
}
