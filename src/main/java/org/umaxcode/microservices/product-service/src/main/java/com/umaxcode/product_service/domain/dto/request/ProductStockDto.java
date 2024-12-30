package com.umaxcode.product_service.domain.dto.request;

import lombok.Builder;

import java.util.List;
import java.util.Map;

@Builder
public record ProductStockDto(
        List<ProductIdAndQuantity> productIdQuantityList
) {
}
