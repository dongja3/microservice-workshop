package com.gt.order.api.controller;


import com.gt.order.api.builder.OrderBuilder;
import com.gt.order.api.dto.OrderRequest;
import com.gt.order.domain.model.Order;
import com.gt.order.domain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public String placeOder(@RequestBody OrderRequest orderRequest){
        Order order = OrderBuilder.buildOrder(orderRequest);
        return  orderService.placeOder(order);
    }
}
