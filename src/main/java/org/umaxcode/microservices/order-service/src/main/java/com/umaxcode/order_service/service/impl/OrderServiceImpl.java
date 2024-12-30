package com.umaxcode.order_service.service.impl;

import com.umaxcode.order_service.client.ProductClient;
import com.umaxcode.order_service.domain.dto.request.OrderPlacingDto;
import com.umaxcode.order_service.domain.dto.response.ProductDto;
import com.umaxcode.order_service.domain.entity.Order;
import com.umaxcode.order_service.exception.ServiceException;
import com.umaxcode.order_service.mapper.OrderMapper;
import com.umaxcode.order_service.repository.OrderRepository;
import com.umaxcode.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductClient productClient;

    @Override
    public Order placeOrder(OrderPlacingDto request) {

        List<ProductDto> productsInSock = productClient.getProductsInSock(request.order());
        BigDecimal totalPrice = calculateTotalPrice(productsInSock);

        if (request.totalPrice().compareTo(totalPrice) < 0) {
            throw new ServiceException("Insufficient funds");
        }

        Order order = Order.builder()
                .orderItems(OrderMapper.toOrderItem(request.order()))
                .totalPrice(totalPrice)
                .build();

        return orderRepository.save(order);
    }

    private BigDecimal calculateTotalPrice(List<ProductDto> productsInSock) {
        return productsInSock.stream()
                .map(ProductDto::price)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    @Override
    public List<Order> getPlacedOrders() {
        return orderRepository.findAll();
    }
}
