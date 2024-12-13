package org.umaxcode.designPatterns.structural.client;

public record JSONPaymentResponse(
        int statusCode,
        String message
) {
}
