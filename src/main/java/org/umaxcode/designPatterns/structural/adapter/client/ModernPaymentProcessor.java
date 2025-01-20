package org.umaxcode.designPatterns.structural.adapter.client;

public interface ModernPaymentProcessor {

    JSONPaymentResponse process(JSONPaymentRequest request);
}
