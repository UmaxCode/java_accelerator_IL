package com.umaxcode.hybrid_integration_test.service;

import com.umaxcode.hybrid_integration_test.domain.dto.OrderRequest;
import com.umaxcode.hybrid_integration_test.domain.entity.Order;

public interface OrderService {
    Order createOrder(OrderRequest request);
}