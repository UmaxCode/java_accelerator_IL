package com.umaxcode.order_service.domain.dto.response;

import com.umaxcode.order_service.domain.dto.request.ProductIdAndQuantity;
import lombok.Builder;

import java.util.List;

@Builder
public record OrderDto(
        Long id,
        List<ProductIdAndQuantity> orderItems
) {
}
