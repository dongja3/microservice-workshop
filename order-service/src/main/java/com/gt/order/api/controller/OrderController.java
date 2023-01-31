package com.gt.order.api.controller;


import com.gt.order.api.builder.OrderBuilder;
import com.gt.order.api.dto.OrderRequest;
import com.gt.order.app.OrderAppService;
import com.gt.order.domain.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderAppService orderAppService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOder(@RequestBody OrderRequest orderRequest){
        Order order = OrderBuilder.buildOrder(orderRequest);
        return  orderAppService.placeOder(order);
    }
}
