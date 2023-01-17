package com.gt.product.domain.service;

import com.gt.product.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product createProduct(Product product);
    List<Product> getAllProducts();

    void deleteAll();

    Optional<Product> findBySkuCode(String skuCode);
}
