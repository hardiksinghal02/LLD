package com.amazon.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrderStatus {

    PLACED("Placed"),
    PAYMENT_PENDING("Payment Pending"),
    SHIPPED("Shipped"),
    OUT_FOR_DELIVER("Out for delivery"),
    DELIVERED("Delivered"),
    CANCELLED("Cancelled"),
    RETURNED("Returned"),
    ;

    private final String name;
}
