package com.bankapp.app.service.util;

import com.bankapp.app.entity.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(String id);

    Product createProduct(String id);

    Product updateProduct(String id);

    List<Product> getAllProducts();

}
