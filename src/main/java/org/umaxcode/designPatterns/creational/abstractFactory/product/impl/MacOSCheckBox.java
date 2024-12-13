package org.umaxcode.designPatterns.creational.abstractFactory.product.impl;

import org.umaxcode.designPatterns.creational.abstractFactory.product.CheckBox;

public class MacOSCheckBox implements CheckBox {

    @Override
    public void checked() {
        System.out.println("MacOS checkbox checked");
    }
}
