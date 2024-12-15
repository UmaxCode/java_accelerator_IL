package com.umaxcode.big_bang_integration_test.domain.dto;

import lombok.Builder;

@Builder
public record OrderPlacementRequestDTO(
        long productId,
        int quantity
) {
}
