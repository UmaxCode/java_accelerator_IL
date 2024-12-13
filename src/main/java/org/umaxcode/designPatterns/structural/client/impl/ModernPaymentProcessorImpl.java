package org.umaxcode.designPatterns.structural.client.impl;

import org.umaxcode.designPatterns.structural.client.JSONPaymentRequest;
import org.umaxcode.designPatterns.structural.client.JSONPaymentResponse;
import org.umaxcode.designPatterns.structural.client.ModernPaymentProcessor;

public class ModernPaymentProcessorImpl implements ModernPaymentProcessor {

    @Override
    public JSONPaymentResponse process(JSONPaymentRequest request) {

        // business logic
        return new JSONPaymentResponse(200, "Payment processed successfully");
    }
}
