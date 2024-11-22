package com.pedro.microservicioSpringBoot.service;

import com.pedro.microservicioSpringBoot.domain.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getProducts();
}
