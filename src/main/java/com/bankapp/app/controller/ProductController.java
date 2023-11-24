package com.bankapp.app.controller;

import com.bankapp.app.dto.ProductTestDto;
import com.bankapp.app.entity.Product;
import com.bankapp.app.mapper.ProductTestMapper;
import com.bankapp.app.service.util.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @RestController
    @RequestMapping("/product")
    @RequiredArgsConstructor
    public class ProductController {

        private final ProductService productService;
        private final ProductTestMapper productTestMapper;

        @GetMapping("/{id}")
        public ResponseEntity<ProductTestDto> getProductById(@PathVariable int id) {
            Product product = productService.getProductById(String.valueOf(id));

            if (product != null) {
                ProductTestDto productTestDto = productTestMapper.toDto(product);
                return ResponseEntity.ok(productTestDto);
            } else {
                return ResponseEntity.notFound().build();
            }
        }


        @GetMapping("/list")
        public ResponseEntity<List<ProductTestDto>> getAllProducts() {
            List<Product> productList = productService.getAllProducts();
            List<ProductTestDto> productDtoList = productTestMapper.toDtoList(productList);
            return ResponseEntity.ok(productDtoList);
        }

        @PostMapping("/create")
        public ResponseEntity<ProductTestDto> createProduct(@RequestBody ProductTestDto productTestDto) {
            Product product = productTestMapper.toEntity(productTestDto);
            Product createdProduct = productService.createProduct(String.valueOf(product));

            if (createdProduct != null) {
                ProductTestDto createdProductTestDto = productTestMapper.toDto(createdProduct);
                return ResponseEntity.ok(createdProductTestDto);
            } else {
                return ResponseEntity.badRequest().build();
            }
        }

        @PutMapping("/update/{id}")
        public ResponseEntity<ProductTestDto> updateProduct(@PathVariable int id, @RequestBody ProductTestDto productTestDto) {
            Product existingProduct = productService.getProductById(String.valueOf(id));

            if (existingProduct != null) {
                Product updatedProduct = productTestMapper.updateFromDto(productTestDto, existingProduct);
                Product savedProduct = productService.updateProduct(String.valueOf(updatedProduct));
                ProductTestDto savedProductDto = productTestMapper.toDto(savedProduct);
                return ResponseEntity.ok(savedProductDto);
            } else {
                return ResponseEntity.notFound().build();
            }
        }
    }