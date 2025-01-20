package org.umaxcode.designPatterns.creational.abstractFactory;

import org.umaxcode.designPatterns.creational.abstractFactory.factory.UIComponentFactory;
import org.umaxcode.designPatterns.creational.abstractFactory.factory.impl.MacOSUIComponentFactory;
import org.umaxcode.designPatterns.creational.abstractFactory.factory.impl.WindowsUIComponentFactory;
import org.umaxcode.designPatterns.creational.abstractFactory.product.Button;
import org.umaxcode.designPatterns.creational.abstractFactory.product.CheckBox;

public class UIComponentCreationDemo {

    public static void main(String[] args) {

        // if windows ui components are needed
        UIComponentFactory windowsUIFactory = new WindowsUIComponentFactory();
        Button windowsButton = windowsUIFactory.createButton();
        windowsButton.onClick();
        CheckBox windowsCheckBox = windowsUIFactory.createCheckBox();
        windowsCheckBox.checked();

        // if MacCS ui components are needed
        UIComponentFactory macOSUIFactory = new MacOSUIComponentFactory();
        Button macOSButton = macOSUIFactory.createButton();
        macOSButton.onClick();
        CheckBox macOSCheckBox = macOSUIFactory.createCheckBox();
        macOSCheckBox.checked();
    }
}
