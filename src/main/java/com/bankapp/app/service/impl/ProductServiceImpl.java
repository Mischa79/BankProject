package com.bankapp.app.service.impl;

import com.bankapp.app.entity.Product;
import com.bankapp.app.service.util.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    @Override
    public Product getProductById(String id) {
        return null;
    }

    @Override
    public Product createProduct(String id) {
        return null;
    }

    @Override
    public Product updateProduct(String id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }
}
