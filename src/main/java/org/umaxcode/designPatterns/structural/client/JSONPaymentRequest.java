package org.umaxcode.designPatterns.structural.client;

public record JSONPaymentRequest(
        double amount,
        String email
) {
}
