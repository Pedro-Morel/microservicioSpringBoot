package com.pedro.microservicioSpringBoot.service;


import com.pedro.microservicioSpringBoot.domain.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductsServiceImpl implements ProductService {

    private List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1, "product1", 100.00, 10),
            new Product(2, "product2", 200.00, 20),
            new Product(3, "product3", 300.00, 30)
    ));

    @Override
    public List<Product> getProducts() {

        return products;
    }
}
