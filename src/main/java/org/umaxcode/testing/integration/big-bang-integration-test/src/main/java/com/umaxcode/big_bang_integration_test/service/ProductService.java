package com.umaxcode.big_bang_integration_test.service;

import com.umaxcode.big_bang_integration_test.domain.entity.Product;

import java.util.List;

public interface ProductService {

    Product getProductIfInStock(long productId, int quantity);

    List<Product> getAllProducts();

    Product saveProduct(Product product);
}
