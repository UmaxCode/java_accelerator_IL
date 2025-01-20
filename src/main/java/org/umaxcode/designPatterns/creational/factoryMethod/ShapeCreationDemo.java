package org.umaxcode.designPatterns.creational.factoryMethod;

import org.umaxcode.designPatterns.creational.factoryMethod.factory.ShapeFactory;
import org.umaxcode.designPatterns.creational.factoryMethod.factory.impl.CircleShapeFactory;
import org.umaxcode.designPatterns.creational.factoryMethod.factory.impl.SquareShapeFactory;
import org.umaxcode.designPatterns.creational.factoryMethod.product.Shape;

public class ShapeCreationDemo {



    public static void main(String[] args) {

        // if circle is needed
        ShapeFactory circleShapeFactory = new CircleShapeFactory(5);
        Shape circle = circleShapeFactory.createShape();
        System.out.println("Area: " + circle.getArea());
        System.out.println("Perimeter: " + circle.getPerimeter());

        // if square is needed
        ShapeFactory squareShapeFactory = new SquareShapeFactory(5);
        Shape square = squareShapeFactory.createShape();
        System.out.println("Area: " + square.getArea());
        System.out.println("Perimeter: " + square.getPerimeter());

    }


}
