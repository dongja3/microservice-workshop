package com.gt.order.app.impl;

import com.gt.order.api.dto.InventoryResponse;
import com.gt.order.app.OrderAppService;
import com.gt.order.domain.event.OrderEvent;
import com.gt.order.domain.model.Order;
import com.gt.order.domain.model.OrderLineItem;
import com.gt.order.domain.service.OrderService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
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

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Override
    public String placeOder(Order order) {
        System.out.println("place Order");
        List<String> skuCodes = order.getOrderLineItems().stream().map(OrderLineItem::getSkuCode).toList();

        for(String skuCode: skuCodes){
            boolean isProductExist = webclientBuilder.build().get().uri("http://product-service",
                    uriBuilder -> uriBuilder.path("/api/product/exist/{skuCode}")
                                    .build(skuCode)).retrieve().bodyToMono(Boolean.class).block();
            if(!isProductExist){
               return "No such product";
            }
        }

        InventoryResponse[] inventoryResponses = webclientBuilder.build().get()
                .uri("http://inventory-service/api/inventory",uriBuilder -> uriBuilder.queryParam("skuCodes", skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();

        boolean allProductsInStock = Arrays.stream(inventoryResponses).allMatch(InventoryResponse::isInStock);
        if (allProductsInStock) {
            Order order1 = orderService.placeOder(order);
            rabbitTemplate.convertAndSend("order-queue", OrderEvent.builder().orderNo(order1.getOrderNo()).build());
            return "Order Placed Successfully";
        }else{
            return "Product is not in stock, please try again later";
//            throw new IllegalArgumentException("Product is not in stock, please try again later");
        }
    }
}
