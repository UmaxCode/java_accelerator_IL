package org.umaxcode.designPatterns.creational.abstractFactory.product.impl;

import org.umaxcode.designPatterns.creational.abstractFactory.product.CheckBox;

public class WindowsCheckBox implements CheckBox {

    @Override
    public void checked() {
        System.out.println("Windows checkbox checked");
    }
}
