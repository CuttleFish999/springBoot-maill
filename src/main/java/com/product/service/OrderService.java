package com.product.service;

import com.product.dto.CreateOrderRequest;

public interface OrderService {

    Integer createOrder(Integer userId , CreateOrderRequest createOderRequest);
}
