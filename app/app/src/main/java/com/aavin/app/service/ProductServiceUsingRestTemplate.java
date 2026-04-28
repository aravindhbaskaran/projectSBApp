package com.aavin.app.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.aavin.app.entity.Product;

@Service
public class ProductServiceUsingRestTemplate {

    private final RestTemplate restTemplate;

    public ProductServiceUsingRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Product> getProducts() {

        String url = "https://fakestoreapi.com/products";

        ResponseEntity<Product[]> response =
                restTemplate.getForEntity(url, Product[].class);

        Product[] products = response.getBody();
        System.out.println("in service");

        return products != null ? Arrays.asList(products) : Collections.emptyList();
    }
}
