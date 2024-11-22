package com.pedro.microservicioSpringBoot.controllers;

import com.pedro.microservicioSpringBoot.domain.Product;
import com.pedro.microservicioSpringBoot.service.ProductService;
import com.pedro.microservicioSpringBoot.service.ProductsServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductController {

    ProductService productsService = new ProductsServiceImpl();

    @GetMapping
    public ResponseEntity<?> getProducts() {
        List<Product> products = productsService.getProducts();

        return ResponseEntity.ok(products);
    }
}
