package com.umaxcode.order_service.domain.dto.response;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductDto(
        String id,
        String name,
        String description,
        Integer quantity,
        BigDecimal price
        ) {
}
