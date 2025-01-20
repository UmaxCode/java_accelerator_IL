package com.umaxcode.big_bang_integration_test.domain.dto;

import lombok.Builder;

@Builder
public record OrderPlacementResponseDTO(
        Long productId,
        Long orderId,
        String productName,
        Integer productQuantity,
        Double totalPrice

) {
}
