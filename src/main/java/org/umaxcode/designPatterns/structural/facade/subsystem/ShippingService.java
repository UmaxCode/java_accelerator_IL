package org.umaxcode.designPatterns.structural.facade.subsystem;

public class ShippingService {
    public String shipProduct(String productId, int quantity) {
        // Ship the product and return a tracking ID
        System.out.println("Shipping product: " + productId);
        return "TRACK12345"; // Dummy tracking ID
    }
}
