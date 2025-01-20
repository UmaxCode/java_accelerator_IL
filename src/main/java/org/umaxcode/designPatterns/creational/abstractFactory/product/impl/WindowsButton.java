package org.umaxcode.designPatterns.creational.abstractFactory.product.impl;

import org.umaxcode.designPatterns.creational.abstractFactory.product.Button;

public class WindowsButton implements Button {

    @Override
    public void onClick() {
        System.out.println("Windows button clicked");
    }
}
