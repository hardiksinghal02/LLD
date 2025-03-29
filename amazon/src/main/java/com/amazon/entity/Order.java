package com.amazon.entity;

import com.amazon.enums.OrderStatus;
import com.lld.entity.AbstractEntity;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Order extends AbstractEntity<Order> {
    private String userId;
    private BigDecimal totalAmount;
    private OrderStatus orderStatus;
    private String paymentId;
    private String shippingAddress;

    @Override
    public Order clone() {
        return null;
    }
}
