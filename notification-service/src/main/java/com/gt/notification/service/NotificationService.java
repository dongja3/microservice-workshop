package com.gt.notification.service;

import com.gt.notification.domain.event.OrderEvent;
import org.springframework.amqp.core.Message;

public interface NotificationService {
    void processOrder(Message message);
}
