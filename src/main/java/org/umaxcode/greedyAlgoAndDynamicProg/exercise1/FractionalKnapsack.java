package org.umaxcode.greedyAlgoAndDynamicProg.exercise1;

import java.util.Arrays;
import java.util.List;

public class FractionalKnapsack {


    // Method to solve the fractional knapsack problem
    public static double getMaxValue(List<Item> items, int capacity) {
        // Sort items by value-to-weight ratio in descending order
        items.sort((a, b) -> Double.compare(b.getValuePerWeight(), a.getValuePerWeight()));

        double totalValue = 0.0;
        int remainingCapacity = capacity;

        // Process each item
        for (Item item : items) {
            if (remainingCapacity == 0) break; // No more room in the knapsack

            if (item.weight <= remainingCapacity) {
                // Take the whole item
                totalValue += item.value;
                remainingCapacity -= item.weight;
            } else {
                // Take the fraction of the item that fits
                totalValue += item.getValuePerWeight() * remainingCapacity;
                remainingCapacity = 0;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {

        // Create a list of items
        List<Item> items = Arrays.asList(
                new Item(60, 10),
                new Item(100, 20),
                new Item(120, 30)
        );

        // Capacity of the knapsack
        int capacity = 50;

        // Get the maximum value that can be carried
        double maxValue = getMaxValue(items, capacity);

        // Output the result
        System.out.println("Maximum value in the knapsack = " + maxValue);
    }
}
