package org.umaxcode.designPatterns.structural.facade;

import org.umaxcode.designPatterns.structural.facade.subsystem.InventoryService;

public class FacadeDemo {

    public static void main(String[] args) {

        InventoryService inventoryService = new InventoryService();
        InventoryFacade inventoryFacade = new InventoryFacade(inventoryService);
        System.out.println("Product availability : " + inventoryFacade.isProjectAvailable("1234567", 23));
    }
}
