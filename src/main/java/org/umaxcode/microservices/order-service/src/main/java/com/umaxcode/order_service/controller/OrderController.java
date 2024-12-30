package com.umaxcode.order_service.controller;

import com.umaxcode.order_service.domain.dto.request.OrderPlacingDto;
import com.umaxcode.order_service.domain.dto.response.OrderDto;
import com.umaxcode.order_service.domain.entity.Order;
import com.umaxcode.order_service.mapper.OrderMapper;
import com.umaxcode.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto placeOrder(@RequestBody OrderPlacingDto request) {

        Order savedOrder = orderService.placeOrder(request);
        return OrderMapper.toOrderDto(savedOrder);
    }

    @GetMapping
    public List<OrderDto> getOrders() {

        List<Order> placedOrders = orderService.getPlacedOrders();
        return OrderMapper.toOrderDtoList(placedOrders);
    }
}
