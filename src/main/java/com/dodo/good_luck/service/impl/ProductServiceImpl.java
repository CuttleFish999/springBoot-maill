package com.dodo.good_luck.service.impl;


import com.dodo.good_luck.dao.ProductDao;
import com.dodo.good_luck.model.Product;
import com.dodo.good_luck.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;
    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }
}
