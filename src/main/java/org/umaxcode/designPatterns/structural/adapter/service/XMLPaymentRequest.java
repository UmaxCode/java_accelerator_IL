package org.umaxcode.designPatterns.structural.adapter.service;

public record XMLPaymentRequest(
        String email,
        double amount
) {
}
