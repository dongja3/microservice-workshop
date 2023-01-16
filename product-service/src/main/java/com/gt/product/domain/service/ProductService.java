package com.gt.product.domain.service;

import com.gt.product.domain.model.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    List<Product> getAllProducts();

    void deleteAll();
}
