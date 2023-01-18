package com.gt.order.domain.event;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderEvent implements Serializable {
    private String orderNo;
}
