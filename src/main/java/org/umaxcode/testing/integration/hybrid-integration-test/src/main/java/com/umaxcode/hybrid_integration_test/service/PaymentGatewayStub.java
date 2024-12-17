package com.umaxcode.hybrid_integration_test.service;

import com.umaxcode.hybrid_integration_test.domain.entity.Order;
import org.springframework.stereotype.Service;

@Service
public class PaymentGatewayStub {
    public boolean processPayment(Order order) {
        return true;
    }
}