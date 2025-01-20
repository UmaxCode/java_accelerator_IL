package org.umaxcode.advancedJavaFeatures.exercise1.factory;

import org.umaxcode.advancedJavaFeatures.exercise1.product.Car;

/**
 * Abstract factory class for car creation.
 * This serves as a blueprint for subclasses to define the specific type of car they produce.
 */
public abstract class CarFactory {

    /**
     * Abstract method to manufacture a car.
     * Subclasses must implement this method to create and return a specific type of car.
     *
     * @return a new instance of a car
     */
    public abstract Car manufactureCar();
}
