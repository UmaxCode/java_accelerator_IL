package org.umaxcode.designPatterns.structural.facade.subsystem;

public class NotificationService {
    public void sendOrderConfirmation(String productId, int quantity, String trackingId) {
        // Send order confirmation to the customer
        System.out.println("Order confirmed. Product: " + productId + ", Quantity: " + quantity + ", Tracking ID: " + trackingId);
    }

    public void sendOrderCancellation(String orderId) {
        // Notify the customer about order cancellation
        System.out.println("Order canceled. Order ID: " + orderId);
    }
}
