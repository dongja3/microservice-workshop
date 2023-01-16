package com.gt.product.domain.repo;

import com.gt.product.domain.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepo extends MongoRepository<Product,String> {
}
