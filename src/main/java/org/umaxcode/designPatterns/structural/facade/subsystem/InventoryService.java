package org.umaxcode.designPatterns.structural.facade.subsystem;

public class InventoryService {

    public boolean isProductAvailable(String productId, int quantity) {
        // Check if the product is available in the inventory
        System.out.println("Checking inventory for product: " + productId);
        return true; // Assume it's available for simplicity
    }
}
