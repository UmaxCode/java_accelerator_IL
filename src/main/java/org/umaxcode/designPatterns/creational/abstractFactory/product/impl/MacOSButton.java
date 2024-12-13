package org.umaxcode.designPatterns.creational.abstractFactory.product.impl;

import org.umaxcode.designPatterns.creational.abstractFactory.product.Button;

public class MacOSButton implements Button {

    @Override
    public void onClick() {
        System.out.println("MacOS button clicked");
    }
}
