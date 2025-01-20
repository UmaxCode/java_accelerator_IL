package com.umaxcode.hybrid_integration_test.service;

import com.umaxcode.hybrid_integration_test.domain.dto.OrderRequest;
import com.umaxcode.hybrid_integration_test.domain.entity.Customer;
import com.umaxcode.hybrid_integration_test.domain.entity.Order;
import com.umaxcode.hybrid_integration_test.domain.entity.OrderItem;
import com.umaxcode.hybrid_integration_test.domain.entity.Product;
import com.umaxcode.hybrid_integration_test.repository.CustomerRepository;
import com.umaxcode.hybrid_integration_test.repository.OrderItemRepository;
import com.umaxcode.hybrid_integration_test.repository.OrderRepository;
import com.umaxcode.hybrid_integration_test.repository.ProductRepository;
import com.umaxcode.hybrid_integration_test.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private OrderItemRepository orderItemRepository;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private OrderServiceImpl orderService;

    @Test
    void createOrder_ShouldAllowACustomerToMakeAnOrder() {

        Long customerId = 1L;
        Long productId = 1L;
        int quantity = 2;

        Customer customer = Customer.builder()
                .id(customerId)
                .build();

        Product product = Product.builder()
                .id(productId)
                .build();

        OrderItem orderItem = OrderItem.builder()
                .quantity(quantity)
                .product(product)
                .build();

        Order order = Order.builder()
                .customer(customer)
                .items(List.of(orderItem))
                .build();

        OrderItem requestItem = OrderItem.builder()
                .quantity(quantity)
                .product(product)
                .build();

        OrderRequest request = OrderRequest.builder()
                .customerId(customerId)
                .items(List.of(requestItem))
                .build();

        when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));
        when(productRepository.findById(productId)).thenReturn(Optional.of(product));
        when(orderItemRepository.save(any(OrderItem.class))).thenReturn(orderItem);
        when(orderRepository.save(any(Order.class))).thenReturn(order);

        Order createdOrder = orderService.createOrder(request);

        assertEquals(customer, createdOrder.getCustomer());
        assertEquals(1, createdOrder.getItems().size());
        assertEquals(quantity, createdOrder.getItems().get(0).getQuantity());
        verify(customerRepository, times(1)).findById(customerId);
        verify(productRepository, times(1)).findById(productId);
        verify(orderItemRepository, times(1)).save(any(OrderItem.class));
        verify(orderRepository, times(1)).save(any(Order.class));
    }
}