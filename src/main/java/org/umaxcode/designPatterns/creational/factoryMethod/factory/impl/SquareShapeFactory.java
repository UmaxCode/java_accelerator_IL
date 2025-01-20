package org.umaxcode.designPatterns.creational.factoryMethod.factory.impl;

import org.umaxcode.designPatterns.creational.factoryMethod.factory.ShapeFactory;
import org.umaxcode.designPatterns.creational.factoryMethod.product.Shape;
import org.umaxcode.designPatterns.creational.factoryMethod.product.impl.Square;

public class SquareShapeFactory implements ShapeFactory {

    private final double side;

    public SquareShapeFactory(double side) {
        this.side = side;
    }

    @Override
    public Shape createShape() {
        return new Square(side);
    }
}
