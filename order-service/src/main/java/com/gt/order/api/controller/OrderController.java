package com.gt.order.api.controller;


import com.gt.order.api.builder.OrderBuilder;
import com.gt.order.api.dto.OrderRequest;
import com.gt.order.app.OrderAppService;
import com.gt.order.domain.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderAppService orderAppService;

    @PostMapping
    public String placeOder(@RequestBody OrderRequest orderRequest){
        Order order = OrderBuilder.buildOrder(orderRequest);
        return  orderAppService.placeOder(order);
    }
}
