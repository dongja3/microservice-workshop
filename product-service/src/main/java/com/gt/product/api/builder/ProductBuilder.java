package com.gt.product.api.builder;

import com.gt.product.api.dto.ProductRequest;
import com.gt.product.api.dto.ProductResponse;
import com.gt.product.domain.model.Product;

public class ProductBuilder {
    public static Product buildProduct(ProductRequest productRequest){
        Product product = Product.builder().name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        return product;
    }

    public static ProductResponse map2Response(Product product){
        return ProductResponse.builder().name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice()).build();
    }
}
