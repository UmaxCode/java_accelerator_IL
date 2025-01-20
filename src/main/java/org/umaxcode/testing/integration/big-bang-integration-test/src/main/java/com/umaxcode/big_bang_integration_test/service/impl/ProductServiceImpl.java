package com.umaxcode.big_bang_integration_test.service.impl;

import com.umaxcode.big_bang_integration_test.domain.entity.Product;
import com.umaxcode.big_bang_integration_test.repository.ProductRepository;
import com.umaxcode.big_bang_integration_test.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product getProductIfInStock(long productId, int quantity) {

        Optional<Product> optionalProduct = productRepository.findProductByIdAndQuantityGreaterThanEqual(
                productId, quantity
        );

        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        }

        throw new IllegalStateException("Product out of stock");
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}
