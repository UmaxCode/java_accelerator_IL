package org.umaxcode.advancedJavaFeatures.exercise1.factory;

import org.umaxcode.advancedJavaFeatures.exercise1.product.Car;
import org.umaxcode.advancedJavaFeatures.exercise1.product.Truck;

/**
 * Factory subclass responsible for creating specific types of cars.
 * This implementation focuses on manufacturing Trucks.
 */
public class TruckFactory extends CarFactory {

    /**
     * Creates and returns an instance of a Truck.
     *
     * @return a new instance of Truck
     */
    @Override
    public Car manufactureCar() {
        return new Truck();
    }
}

