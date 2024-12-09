package org.umaxcode.treesAndGraphs.exercise2;

import java.util.ArrayList;
import java.util.List;

public class MinHeapDemo {

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();

        List<Task> list = new ArrayList<>();
        list.add(new Task(3, "Wake up"));
        list.add(new Task(19, "Code"));
        list.add(new Task(10, "Eat"));
        list.add(new Task(27, "Sleep"));
        list.add(new Task(26, "Wake up"));
        list.add(new Task(23, "Code"));

        for (Task x : list) {
            minHeap.add(x);
        }

        System.out.println("--------------");
        System.out.println("BUBBLED UP");
        minHeap.displayHeap();

        // Remove minimum value multiple times
        for (int i = 0; i < 6; i++) {
            System.out.println("--------------");
            minHeap.popMin();
            System.out.println("HEAPIFIED");
            minHeap.displayHeap();
        }
    }
}
