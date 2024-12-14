package com.umaxcode.unit_test_with_mockito.repository;

import com.umaxcode.unit_test_with_mockito.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class OrderRepository {

    private final List<Order> orderStore = new ArrayList<>();

    public Order save(Order order) {

        Order savedOrder = Order.builder()
                .id(UUID.randomUUID().toString())
                .userId(order.getUserId())
                .productId(order.getProductId())
                .quantity(order.getQuantity())
                .build();

        orderStore.add(savedOrder);
        return savedOrder;
    }
}
