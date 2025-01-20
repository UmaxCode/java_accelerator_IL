package org.umaxcode.designPatterns.behavioral.strategy;

import org.umaxcode.designPatterns.behavioral.strategy.impl.BubbleSort;
import org.umaxcode.designPatterns.behavioral.strategy.impl.QuickSort;

import java.util.Arrays;

public class StrategyDemo {

    public static void main(String[] args) {

        int[] array = {5, 2, 9, 1, 5, 6};

        SortContext context = new SortContext();

        // Use Bubble Sort
        context.setStrategy(new BubbleSort());
        context.execute(array);
        System.out.println("Sorted using Bubble Sort.");
        System.out.println(Arrays.toString(array) + "\n");

        // Use Quick Sort
        int[] array2 = {3, 7, 8, 5, 2, 1, 9, 5, 4};
        context.setStrategy(new QuickSort());
        context.execute(array2);
        System.out.println("Sorted using Quick Sort.");
        System.out.println(Arrays.toString(array2));
    }
}
