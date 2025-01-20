package com.umaxcode.hybrid_integration_test.domain.dto;

import com.umaxcode.hybrid_integration_test.domain.entity.OrderItem;
import lombok.Builder;

import java.util.List;

@Builder
public record OrderRequest(Long customerId,
                           List<OrderItem> items) {
}
