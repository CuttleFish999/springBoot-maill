package com.product.dao;

import com.product.dto.ProductRequest;
import com.product.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

}
