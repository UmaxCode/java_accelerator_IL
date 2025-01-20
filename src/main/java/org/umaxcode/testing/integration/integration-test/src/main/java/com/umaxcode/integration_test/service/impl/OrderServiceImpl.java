package com.umaxcode.integration_test.service.impl;

import com.umaxcode.integration_test.entity.Order;
import com.umaxcode.integration_test.repository.OrderRepository;
import com.umaxcode.integration_test.service.OrderService;
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
