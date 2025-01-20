package org.umaxcode.designPatterns.structural.adapter.client;

public record JSONPaymentResponse(
        int statusCode,
        String message
) {
}
