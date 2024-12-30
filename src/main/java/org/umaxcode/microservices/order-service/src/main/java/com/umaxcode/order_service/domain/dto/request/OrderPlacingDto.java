package com.umaxcode.order_service.domain.dto.request;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

@Builder
public record OrderPlacingDto(
        List<ProductIdAndQuantity> order,
        BigDecimal totalPrice
) {
}
