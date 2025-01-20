package org.umaxcode.designPatterns.behavioral.strategy.Utils;

public class SortUtility {

    private SortUtility() {

    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
