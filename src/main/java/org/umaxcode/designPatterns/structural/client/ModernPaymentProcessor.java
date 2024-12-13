package org.umaxcode.designPatterns.structural.client;

public interface ModernPaymentProcessor {

    JSONPaymentResponse process(JSONPaymentRequest request);
}
