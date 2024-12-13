package org.umaxcode.designPatterns.structural.adapter.client.impl;

import org.umaxcode.designPatterns.structural.adapter.client.JSONPaymentRequest;
import org.umaxcode.designPatterns.structural.adapter.client.JSONPaymentResponse;
import org.umaxcode.designPatterns.structural.adapter.client.ModernPaymentProcessor;

public class ModernPaymentProcessorImpl implements ModernPaymentProcessor {

    @Override
    public JSONPaymentResponse process(JSONPaymentRequest request) {

        // business logic
        return new JSONPaymentResponse(200, "Payment processed successfully");
    }
}
