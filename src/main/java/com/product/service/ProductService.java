package com.product.service;

import com.product.constant.ProductCategory;
import com.product.dto.ProductQueryParams;
import com.product.dto.ProductRequest;
import com.product.model.Product;

import java.util.List;

public interface ProductService {

    Integer countProduct(ProductQueryParams productQueryParams);

    List<Product> getProducts(ProductQueryParams productQueryParams);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId , ProductRequest productRequest);
}
