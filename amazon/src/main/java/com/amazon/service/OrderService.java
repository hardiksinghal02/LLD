package com.amazon.service;

import com.amazon.entity.Order;
import com.amazon.entity.OrderItem;
import com.amazon.request.OrderSearchRequest;

import java.util.List;

public interface OrderService {

    List<OrderItem> fetchOrderItems(String orderId);

    List<Order> fetchOrders(OrderSearchRequest searchRequest);

    Order cancelOrder(Order order);
}
