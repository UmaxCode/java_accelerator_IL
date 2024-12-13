package org.umaxcode.designPatterns.creational.abstractFactory.factory.impl;

import org.umaxcode.designPatterns.creational.abstractFactory.factory.UIComponentFactory;
import org.umaxcode.designPatterns.creational.abstractFactory.product.Button;
import org.umaxcode.designPatterns.creational.abstractFactory.product.CheckBox;
import org.umaxcode.designPatterns.creational.abstractFactory.product.impl.WindowsButton;
import org.umaxcode.designPatterns.creational.abstractFactory.product.impl.WindowsCheckBox;

public class WindowsUIComponentFactory implements UIComponentFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowsCheckBox();
    }
}
