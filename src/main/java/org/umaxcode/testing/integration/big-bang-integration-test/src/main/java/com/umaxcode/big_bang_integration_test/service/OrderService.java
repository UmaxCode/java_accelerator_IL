package com.umaxcode.big_bang_integration_test.service;

import com.umaxcode.big_bang_integration_test.domain.dto.OrderPlacementRequestDTO;
import com.umaxcode.big_bang_integration_test.domain.entity.Order;

public interface OrderService {

    Order placeOrder(OrderPlacementRequestDTO request);
}
