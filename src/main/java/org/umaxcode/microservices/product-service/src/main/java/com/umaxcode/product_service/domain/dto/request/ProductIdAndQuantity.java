package com.umaxcode.product_service.domain.dto.request;

import lombok.Builder;

@Builder
public record ProductIdAndQuantity(
        Long id,
        Integer quantity
) {
}
