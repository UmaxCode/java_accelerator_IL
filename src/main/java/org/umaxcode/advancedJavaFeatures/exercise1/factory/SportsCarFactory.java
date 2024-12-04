package org.umaxcode.advancedJavaFeatures.exercise1.factory;

import org.umaxcode.advancedJavaFeatures.exercise1.product.Car;
import org.umaxcode.advancedJavaFeatures.exercise1.product.SportsCar;

/**
 * Factory subclass responsible for creating specific types of cars.
 * This implementation focuses on manufacturing Sports Cars.
 */
public class SportsCarFactory extends CarFactory {

    /**
     * Creates and returns an instance of a Sports Car.
     *
     * @return a new instance of SportsCar
     */
    @Override
    public Car manufactureCar() {
        return new SportsCar();
    }
}
