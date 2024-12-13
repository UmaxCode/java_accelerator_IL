package org.umaxcode.designPatterns.structural.adapter.service;

public record XMLPaymentResponse(
        int statusCode,
        String message
) {
}
