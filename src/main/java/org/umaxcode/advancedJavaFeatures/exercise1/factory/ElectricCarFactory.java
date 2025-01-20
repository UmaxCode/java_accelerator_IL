package org.umaxcode.advancedJavaFeatures.exercise1.factory;

import org.umaxcode.advancedJavaFeatures.exercise1.product.Car;
import org.umaxcode.advancedJavaFeatures.exercise1.product.ElectricCar;

/**
 * Factory subclass responsible for creating specific types of cars.
 * This implementation focuses on manufacturing Electric Cars.
 */
public class ElectricCarFactory extends CarFactory {

    /**
     * Creates and returns an instance of an Electric Car.
     *
     * @return a new instance of ElectricCar
     */
    @Override
    public Car manufactureCar() {
        return new ElectricCar();
    }
}
