package com.ro.orderservice.service;

import com.ro.orderservice.dto.OrderRequest;

public interface OrderService {
    public void placeOrder(OrderRequest orderRequest);
}
