package com.umaxcode.hybrid_integration_test.service;

import com.umaxcode.hybrid_integration_test.domain.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(Long id);

}
