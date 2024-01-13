package com.product.service.impl;

import com.product.dao.OrderDao;
import com.product.dao.ProductDao;
import com.product.dto.BuyItem;
import com.product.dto.CreateOderRequest;
import com.product.model.OrderItem;
import com.product.model.Product;
import com.product.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;
    List<OrderItem> orderItemList = new ArrayList<>();


    @Transactional
    @Override
    public Integer createOrder(Integer userId, CreateOderRequest createOderRequest) {

        int totalAmount = 0;

        for(BuyItem buyItem : createOderRequest.getBuyItemList()){
            Product product = productDao.getProductById(buyItem.getProductId());
//          計算
            int amount = buyItem.getQuantity() * product.getPrice();
            totalAmount = totalAmount + amount;

//          BuyItem 轉換成 OrderItem
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(buyItem.getProductId());
            orderItem.setQuantity(buyItem.getQuantity());
            orderItem.setAmount(amount);

            orderItemList.add(orderItem);
        }

//      創立訂單
        Integer orderId = orderDao.createOrder(userId , totalAmount);

        orderDao.createOrderItems(orderId , orderItemList);

        return orderId;
    }
}
