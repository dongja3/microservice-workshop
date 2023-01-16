package com.gt.product.api.controller;

import com.gt.product.api.builder.ProductBuilder;
import com.gt.product.api.dto.ProductRequest;
import com.gt.product.api.dto.ProductResponse;
import com.gt.product.domain.model.Product;
import com.gt.product.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        Product product = ProductBuilder.buildProduct(productRequest);
        productService.createProduct(product);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
        List<Product> products =  productService.getAllProducts();
        return products.stream().map(product -> ProductBuilder.map2Response(product)).toList();
    }

    @GetMapping
    @RequestMapping(path="/delete")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAll(){
        productService.deleteAll();
    }
}
