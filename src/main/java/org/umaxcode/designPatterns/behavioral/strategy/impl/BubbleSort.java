package org.umaxcode.designPatterns.behavioral.strategy.impl;

import org.umaxcode.designPatterns.behavioral.strategy.SortingStrategy;

import static org.umaxcode.designPatterns.behavioral.strategy.Utils.SortUtility.swap;

public class BubbleSort implements SortingStrategy {

    @Override
    public void sort(int[] array) {

        boolean swapping = true;

        while (swapping) {
            swapping = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    swapping = true;
                }
            }
        }
    }

}
