package com.umaxcode.order_service.service;

import com.umaxcode.order_service.domain.dto.request.OrderPlacingDto;
import com.umaxcode.order_service.domain.entity.Order;

import java.util.List;

public interface OrderService {

    Order placeOrder(OrderPlacingDto request);

    List<Order> getPlacedOrders();
}
