package com.umaxcode.hybrid_integration_test.service.impl;

import com.umaxcode.hybrid_integration_test.domain.dto.OrderRequest;
import com.umaxcode.hybrid_integration_test.domain.entity.Customer;
import com.umaxcode.hybrid_integration_test.domain.entity.Order;
import com.umaxcode.hybrid_integration_test.domain.entity.OrderItem;
import com.umaxcode.hybrid_integration_test.domain.entity.Product;
import com.umaxcode.hybrid_integration_test.repository.CustomerRepository;
import com.umaxcode.hybrid_integration_test.repository.OrderItemRepository;
import com.umaxcode.hybrid_integration_test.repository.OrderRepository;
import com.umaxcode.hybrid_integration_test.repository.ProductRepository;
import com.umaxcode.hybrid_integration_test.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final OrderItemRepository orderItemRepository;
    private final ProductRepository productRepository;

    @Override
    public Order createOrder(OrderRequest request) {
        Customer customer = customerRepository.findById(request.customerId()).orElse(null);

        List<OrderItem> orderItems = request.items().stream()
                .map(requestItem -> {
                    Product product = productRepository.findById(requestItem.getProduct().getId())
                            .orElse(null);
                    OrderItem orderItem = OrderItem.builder()
                            .quantity(requestItem.getQuantity())
                            .product(product)
                            .build();
                    return orderItemRepository.save(orderItem);
                })
                .toList();

        Order order = Order.builder()
                .customer(customer)
                .items(orderItems)
                .build();

        return orderRepository.save(order);
    }
}
