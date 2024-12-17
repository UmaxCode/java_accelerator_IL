package com.umaxcode.hybrid_integration_test.controller;


import com.umaxcode.hybrid_integration_test.domain.dto.OrderRequest;
import com.umaxcode.hybrid_integration_test.domain.entity.Order;
import com.umaxcode.hybrid_integration_test.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public Order createOrder(@RequestBody OrderRequest request) {
        return orderService.createOrder(request);
    }
}
