package com.umaxcode.integration_test.service.impl;

import com.umaxcode.integration_test.entity.Order;
import com.umaxcode.integration_test.repository.OrderRepository;
import com.umaxcode.integration_test.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource( locations = "classpath:application-test.properties")
class OrderServiceImplTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;


    @Test
    void saveOrder_ShouldAddAnOrderToTheDatabase(){

        Order order = Order.builder()
                .userId(1L)
                .productId(1L)
                .quantity(4L)
                .build();

        Order savedOrder = orderService.saveOrder(order);

        assertNotNull(savedOrder);
        assertEquals(order.getUserId(), savedOrder.getUserId());
        assertEquals(order.getProductId(), savedOrder.getProductId());
        assertEquals(order.getProductId(), savedOrder.getProductId());

        Order fetchedOrder = orderRepository.findById(savedOrder.getId()).orElse(null);

        assertNotNull(fetchedOrder);
        System.out.println(fetchedOrder);
    }
}