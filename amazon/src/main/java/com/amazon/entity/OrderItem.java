package com.amazon.entity;

import com.lld.entity.AbstractEntity;

import java.math.BigDecimal;

public class OrderItem extends AbstractEntity<OrderItem> {

    private String orderId;
    private String productId;
    private Integer quantity;
    private BigDecimal pricePerItem;

    @Override
    public OrderItem clone() {
        // TODO:
        return null;
    }
}
