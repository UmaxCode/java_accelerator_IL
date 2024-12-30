package com.umaxcode.product_service.domain.dto.response;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductDto(
        Long id,
        String name,
        String description,
        Integer quantity,
        BigDecimal price
) {
}
