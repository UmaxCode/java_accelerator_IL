package org.umaxcode.designPatterns.creational.abstractFactory.factory;

import org.umaxcode.designPatterns.creational.abstractFactory.product.Button;
import org.umaxcode.designPatterns.creational.abstractFactory.product.CheckBox;

public interface UIComponentFactory {

    Button createButton();

    CheckBox createCheckBox();
}
