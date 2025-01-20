package org.umaxcode.designPatterns.structural.adapter.client;

public class MyApplication {

    private final ModernPaymentProcessor processor;

    public MyApplication(ModernPaymentProcessor processor) {
        this.processor = processor;
    }

    public JSONPaymentResponse makePayment(JSONPaymentRequest request) {
        return processor.process(request);
    }
}
