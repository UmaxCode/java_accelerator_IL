package com.umaxcode.unit_test_with_mockito.service.impl;

import com.umaxcode.unit_test_with_mockito.entity.Order;
import com.umaxcode.unit_test_with_mockito.repository.OrderRepository;
import com.umaxcode.unit_test_with_mockito.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }
}
