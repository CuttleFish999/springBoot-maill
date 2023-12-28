package com.product.service;

import com.product.dto.ProductRequest;
import com.product.model.Product;

public interface ProductService {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);
}
