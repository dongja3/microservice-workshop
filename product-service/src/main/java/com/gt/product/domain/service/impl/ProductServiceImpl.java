package com.gt.product.domain.service.impl;

import com.gt.product.domain.model.Product;
import com.gt.product.domain.repo.ProductRepo;
import com.gt.product.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;
    @Override
    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public void deleteAll() {
        productRepo.deleteAll();
    }

    @Override
    public Optional<Product> findBySkuCode(String skuCode) {
      return  productRepo.findBySkuCode(skuCode);
    }
}
