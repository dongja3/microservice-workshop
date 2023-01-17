package com.gt.order.domain.service.impl;

import com.gt.order.domain.model.Order;
import com.gt.order.domain.repo.OrderRepo;
import com.gt.order.domain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Override
    public String placeOder(Order order) {
        orderRepo.save(order);
        return "Order placed successfully";
    }
}
