package com.shopping.service;

import com.shopping.model.OrderDetails;

import java.util.List;

public interface OrderDetailsService {
    public void submitOrder(OrderDetails orderDetails);
    public List<OrderDetails> getAllOrders();
}
