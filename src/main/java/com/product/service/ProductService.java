package com.product.service;

import com.product.constant.ProductCategory;
import com.product.dto.ProductRequest;
import com.product.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts(ProductCategory category ,String search);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId , ProductRequest productRequest);
}
