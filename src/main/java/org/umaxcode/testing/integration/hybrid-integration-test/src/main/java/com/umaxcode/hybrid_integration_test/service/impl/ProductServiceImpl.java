package com.umaxcode.hybrid_integration_test.service.impl;

import com.umaxcode.hybrid_integration_test.domain.entity.Product;
import com.umaxcode.hybrid_integration_test.repository.ProductRepository;
import com.umaxcode.hybrid_integration_test.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {

        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        }

        throw new IllegalStateException("Product not found");
    }
}