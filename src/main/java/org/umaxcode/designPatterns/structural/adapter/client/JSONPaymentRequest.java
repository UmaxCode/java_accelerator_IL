package org.umaxcode.designPatterns.structural.adapter.client;

public record JSONPaymentRequest(
        double amount,
        String email
) {
}
