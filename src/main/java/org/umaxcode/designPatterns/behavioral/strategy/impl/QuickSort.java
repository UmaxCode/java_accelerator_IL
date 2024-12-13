package org.umaxcode.designPatterns.behavioral.strategy.impl;

import org.umaxcode.designPatterns.behavioral.strategy.SortingStrategy;

import static org.umaxcode.designPatterns.behavioral.strategy.Utils.SortUtility.swap;

public class QuickSort implements SortingStrategy {

    @Override
    public void sort(int[] array) {
        if (array.length <= 1) return;

        quickSort(array, 0, array.length - 1);
    }

    public void quickSort(int[] array, int low, int high) {

        if (low < high) {
            int pi = partition(array, low, high);

            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }

    }

    public int partition(int[] array, int low, int high) {

        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }
}
