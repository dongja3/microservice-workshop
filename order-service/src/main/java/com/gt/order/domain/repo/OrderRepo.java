package com.gt.order.domain.repo;

import com.gt.order.domain.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Long> {
}
