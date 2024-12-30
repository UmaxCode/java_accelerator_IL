package com.umaxcode.product_service.service.impl;

import com.umaxcode.product_service.domain.dto.request.ProductCreationDto;
import com.umaxcode.product_service.domain.dto.request.ProductIdAndQuantity;
import com.umaxcode.product_service.domain.entity.Product;
import com.umaxcode.product_service.exception.ServiceException;
import com.umaxcode.product_service.mapper.ProductMapper;
import com.umaxcode.product_service.repository.ProductRepository;
import com.umaxcode.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product createProduct(ProductCreationDto request) {
        Product productInstance = ProductMapper.fromProductCreationDto(request);
        return productRepository.save(productInstance);
    }

    @Override
    public Product getProduct(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElseThrow(() -> new ServiceException("Product with id " + id + " not found"));
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsInStock(List<ProductIdAndQuantity> idAndQuantity) {
        return idAndQuantity.stream()
                .map(idQuant -> {
                    Product product = getProduct(idQuant.id());
                    if (product.getQuantity() <= idQuant.quantity()) {
                        throw new ServiceException("Product with id " + idQuant.id() + " is out of stock");
                    }
                    return product;
                }).toList();
    }
}
