package com.product.dao;

import com.product.model.OrderItem;

import java.util.List;

public interface OrderDao {

    Integer createOrder(Integer userId , Integer totalAmount);

    void createOrderItems(Integer orderId , List<OrderItem> oderItemList);
}
