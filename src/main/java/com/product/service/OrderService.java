package com.product.service;

import com.product.dto.CreateOderRequest;

public interface OrderService {

    Integer createOrder(Integer userId , CreateOderRequest createOderRequest);
}
