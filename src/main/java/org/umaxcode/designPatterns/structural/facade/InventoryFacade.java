package org.umaxcode.designPatterns.structural.facade;

import org.umaxcode.designPatterns.structural.facade.subsystem.InventoryService;

public class InventoryFacade {

    private final InventoryService inventoryService;

    public InventoryFacade(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public boolean isProjectAvailable(String productID, int quantity) {
        return inventoryService.isProductAvailable(productID, quantity);
    }
}
