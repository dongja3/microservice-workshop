package com.gt.order.app.impl;

import com.gt.order.api.dto.InventoryResponse;
import com.gt.order.app.OrderAppService;
import com.gt.order.domain.model.Order;
import com.gt.order.domain.model.OrderLineItem;
import com.gt.order.domain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;

@Service
public class OrderAppServiceImpl  implements OrderAppService {

    @Autowired
    private OrderService orderService;

    @Autowired
    private WebClient.Builder webclientBuilder;

    @Override
    public String placeOder(Order order) {

        List<String> skuCodes = order.getOrderLineItems().stream().map(OrderLineItem::getSkuCode).toList();
        InventoryResponse[] inventoryResponses = webclientBuilder.build().get()
                .uri("http://localhost:8091/api/inventory",uriBuilder -> uriBuilder.queryParam("skuCodes", skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();

        boolean allProductsInStock = Arrays.stream(inventoryResponses).allMatch(InventoryResponse::isInStock);
        if (allProductsInStock) {
            orderService.placeOder(order);
            return "Order Placed Successfully";
        }else{
            throw new IllegalArgumentException("Product is not in stock, please try again later");
        }
    }
}
