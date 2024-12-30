package com.umaxcode.product_service.service;

import com.umaxcode.product_service.domain.dto.request.ProductCreationDto;
import com.umaxcode.product_service.domain.dto.request.ProductIdAndQuantity;
import com.umaxcode.product_service.domain.dto.request.ProductStockDto;
import com.umaxcode.product_service.domain.entity.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(ProductCreationDto request);

    Product getProduct(Long id);

    List<Product> getProducts();

    List<Product> getProductsInStock(List<ProductIdAndQuantity> idAndQuantity);
}
