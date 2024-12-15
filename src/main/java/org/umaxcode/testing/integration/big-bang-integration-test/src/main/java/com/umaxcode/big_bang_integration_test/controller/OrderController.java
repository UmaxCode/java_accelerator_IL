package com.umaxcode.big_bang_integration_test.controller;

import com.umaxcode.big_bang_integration_test.domain.dto.OrderPlacementRequestDTO;
import com.umaxcode.big_bang_integration_test.domain.dto.OrderPlacementResponseDTO;
import com.umaxcode.big_bang_integration_test.domain.entity.Order;
import com.umaxcode.big_bang_integration_test.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderPlacementResponseDTO placeOrder(@RequestBody OrderPlacementRequestDTO orderRequest) {

        Order order = orderService.placeOrder(orderRequest);

        return OrderPlacementResponseDTO.builder()
                .orderId(order.getId())
                .productId(orderRequest.productId())
                .productName(order.getProduct().getName())
                .productQuantity(orderRequest.quantity())
                .totalPrice(order.getProduct().getPrice() * orderRequest.quantity())
                .build();
    }
}
