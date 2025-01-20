package org.umaxcode.greedyAlgoAndDynamicProg.exercise1;

public class Item {

    int value;
    int weight;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    // Calculate the value-to-weight ratio
    double getValuePerWeight() {
        return (double) value / weight;
    }
}
