package org.umaxcode.designPatterns.structural.facade.subsystem;

public class PaymentService {

    public boolean processPayment(PaymentDetails paymentDetails) {
        // Process payment
        System.out.println("Processing payment...");
        return true; // Assume payment is successful for simplicity
    }

    public boolean processRefund(String orderId) {
        // Process refund
        System.out.println("Processing refund for order: " + orderId);
        return true; // Assume refund is successful for simplicity
    }
}
