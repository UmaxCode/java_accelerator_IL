package org.umaxcode.designPatterns.structural.adapter;

import org.umaxcode.designPatterns.structural.adapter.adapter.LegacyPaymentProcessorAdapter;
import org.umaxcode.designPatterns.structural.adapter.service.LegacyPaymentProcessor;
import org.umaxcode.designPatterns.structural.adapter.service.impl.LegacyPaymentProcessorImpl;
import org.umaxcode.designPatterns.structural.adapter.client.JSONPaymentRequest;
import org.umaxcode.designPatterns.structural.adapter.client.JSONPaymentResponse;
import org.umaxcode.designPatterns.structural.adapter.client.ModernPaymentProcessor;
import org.umaxcode.designPatterns.structural.adapter.client.MyApplication;
import org.umaxcode.designPatterns.structural.adapter.client.impl.ModernPaymentProcessorImpl;

public class PaymentProcessorDemo {

    public static void main(String[] args) {

        ModernPaymentProcessor modernPaymentProcessor = new ModernPaymentProcessorImpl();
        MyApplication myApplication = new MyApplication(modernPaymentProcessor);

        JSONPaymentResponse jsonPaymentResponse = myApplication.makePayment(
                new JSONPaymentRequest(1000, "example@gmail.com")
        );
        System.out.println(jsonPaymentResponse.toString());


        LegacyPaymentProcessor legacyPaymentProcessor = new LegacyPaymentProcessorImpl();
        LegacyPaymentProcessorAdapter paymentProcessorAdapter = new LegacyPaymentProcessorAdapter(legacyPaymentProcessor);
        MyApplication myApplication1 = new MyApplication(paymentProcessorAdapter);
        JSONPaymentResponse jsonPaymentResponse1 = myApplication1.makePayment(
                new JSONPaymentRequest(2000, "example@gmail.com")
        );
        System.out.println(jsonPaymentResponse1.toString());
    }
}
