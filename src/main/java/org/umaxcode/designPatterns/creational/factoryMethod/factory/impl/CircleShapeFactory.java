package org.umaxcode.designPatterns.creational.factoryMethod.factory.impl;

import org.umaxcode.designPatterns.creational.factoryMethod.factory.ShapeFactory;
import org.umaxcode.designPatterns.creational.factoryMethod.product.Shape;
import org.umaxcode.designPatterns.creational.factoryMethod.product.impl.Circle;

public class CircleShapeFactory implements ShapeFactory {
    private final double radius;

    public CircleShapeFactory(double radius) {
        this.radius = radius;
    }

    @Override
    public Shape createShape() {
        return new Circle(radius);
    }
}
