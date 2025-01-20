package com.umaxcode.unit_test_with_mockito.service.impl;

import com.umaxcode.unit_test_with_mockito.entity.Order;
import com.umaxcode.unit_test_with_mockito.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderServiceImpl orderService;

    @Test
    void saveOrder_ShouldAddAnOrderToTheRepositoryStory() {

        Order order = Order.builder()
                .userId(1)
                .productId(1)
                .quantity(4)
                .build();

        Order savedOrder = order.toBuilder().id(UUID.randomUUID().toString()).build();

        when(orderRepository.save(order)).thenReturn(savedOrder);

        Order returnedSavedOrder = orderService.saveOrder(order);

        assertNotNull(returnedSavedOrder);
        assertEquals(savedOrder.getId(), returnedSavedOrder.getId());
        assertEquals(returnedSavedOrder.getProductId(), order.getProductId());
        assertEquals(returnedSavedOrder.getQuantity(), order.getQuantity());
        assertEquals(returnedSavedOrder.getUserId(), order.getUserId());

        verify(orderRepository, times(1)).save(order);
    }

    @Test
    void saveOrder_ShouldFailedToAddAnOrderToTheRepositoryStory() {

        Order order = Order.builder()
                .userId(1)
                .productId(1)
                .quantity(4)
                .build();

        when(orderRepository.save(order)).thenReturn(null);

        Order returnedSavedOrder = orderService.saveOrder(order);

        assertNull(returnedSavedOrder);
    }

}