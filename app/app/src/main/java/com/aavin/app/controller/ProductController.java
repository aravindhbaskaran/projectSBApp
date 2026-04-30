package com.aavin.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aavin.app.entity.Product;
//import com.aavin.app.service.ProductService;
import com.aavin.app.service.ProductServiceUsingRestTemplate;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	private ProductServiceUsingRestTemplate service;
//    private  ProductService service;

    public ProductController(ProductServiceUsingRestTemplate service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return service.getProducts();
    }
}