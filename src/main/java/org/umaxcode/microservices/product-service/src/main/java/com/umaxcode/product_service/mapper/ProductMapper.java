package com.umaxcode.product_service.mapper;

import com.umaxcode.product_service.domain.dto.request.ProductCreationDto;
import com.umaxcode.product_service.domain.dto.response.ProductDto;
import com.umaxcode.product_service.domain.entity.Product;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductMapper {

    public static Product fromProductCreationDto(ProductCreationDto dto) {
        return Product.builder()
                .name(dto.name())
                .description(dto.description())
                .quantity(dto.quantity())
                .price(dto.price())
                .build();
    }

    public static ProductDto fromProductInstance(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .quantity(product.getQuantity())
                .price(product.getPrice())
                .build();
    }

    public static List<ProductDto> fromProductInstances(List<Product> products) {
        return products.stream()
                .map(ProductMapper::fromProductInstance)
                .toList();
    }
}
