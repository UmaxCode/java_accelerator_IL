package org.umaxcode.designPatterns.creational.abstractFactory.factory.impl;

import org.umaxcode.designPatterns.creational.abstractFactory.factory.UIComponentFactory;
import org.umaxcode.designPatterns.creational.abstractFactory.product.Button;
import org.umaxcode.designPatterns.creational.abstractFactory.product.CheckBox;
import org.umaxcode.designPatterns.creational.abstractFactory.product.impl.MacOSButton;
import org.umaxcode.designPatterns.creational.abstractFactory.product.impl.MacOSCheckBox;

public class MacOSUIComponentFactory implements UIComponentFactory {

    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacOSCheckBox();
    }
}
