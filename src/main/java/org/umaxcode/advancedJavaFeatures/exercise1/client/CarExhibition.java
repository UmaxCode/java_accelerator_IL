package org.umaxcode.advancedJavaFeatures.exercise1.client;

import org.umaxcode.advancedJavaFeatures.exercise1.factory.CarFactory;
import org.umaxcode.advancedJavaFeatures.exercise1.factory.ElectricCarFactory;
import org.umaxcode.advancedJavaFeatures.exercise1.factory.SportsCarFactory;
import org.umaxcode.advancedJavaFeatures.exercise1.factory.TruckFactory;
import org.umaxcode.advancedJavaFeatures.exercise1.product.Car;

/**
 * Factory Method is a creational design pattern that defines an interface for creating objects in a superclass,
 * while allowing subclasses to decide the specific type of objects to create.
 *
 * <h1>When to Use the Factory Method</h1>
 * <ol>
 *     <li><b>Unknown Dependencies:</b> Use the Factory Method when the exact types and dependencies of the objects
 *         (Products) your code will work with are not known beforehand.</li>
 *     <li><b>Extensibility:</b> Use the Factory Method to allow users of your library or framework to extend its
 *         internal components by providing custom object creation logic.</li>
 *     <li><b>Resource Optimization:</b> Use the Factory Method to save system resources by reusing existing objects
 *         rather than recreating them each time.</li>
 * </ol>
 */
public class CarExhibition {

    public static void main(String[] args) {

        // if fans want to see an electric car show it
        CarFactory factory = new ElectricCarFactory();
        Car electricCar = factory.manufactureCar();
        electricCar.drive();

        // if fans want to see a sports car show it
        CarFactory factory1 = new SportsCarFactory();
        Car sportsCar = factory1.manufactureCar();
        sportsCar.drive();

        // if fans want to see a truck show it
        CarFactory factory2 = new TruckFactory();
        Car truck = factory2.manufactureCar();
        truck.drive();

    }
}
