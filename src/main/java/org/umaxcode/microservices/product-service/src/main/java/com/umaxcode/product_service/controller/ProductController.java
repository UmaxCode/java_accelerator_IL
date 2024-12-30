package com.umaxcode.product_service.controller;

import com.umaxcode.product_service.domain.dto.request.ProductCreationDto;
import com.umaxcode.product_service.domain.dto.request.ProductIdAndQuantity;
import com.umaxcode.product_service.domain.dto.request.ProductStockDto;
import com.umaxcode.product_service.domain.dto.response.ProductDto;
import com.umaxcode.product_service.domain.entity.Product;
import com.umaxcode.product_service.mapper.ProductMapper;
import com.umaxcode.product_service.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto addProduct(@Valid @RequestBody ProductCreationDto request) {

        Product savedProduct = productService.createProduct(request);
        return ProductMapper.fromProductInstance(savedProduct);
    }

    @GetMapping
    public List<ProductDto> getAllProducts() {

        List<Product> products = productService.getProducts();
        return ProductMapper.fromProductInstances(products);
    }

    @GetMapping("/{id}")
    public ProductDto getProduct(@PathVariable Long id) {

        Product product = productService.getProduct(id);
        return ProductMapper.fromProductInstance(product);
    }

    @PostMapping("/in-stock")
    public List<ProductDto> getProductsInSock(@RequestBody List<ProductIdAndQuantity> request) {

        List<Product> productsInStock = productService.getProductsInStock(request);
        return ProductMapper.fromProductInstances(productsInStock);
    }


}
