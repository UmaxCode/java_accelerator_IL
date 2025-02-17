package org.umaxcode.performance_optimization_techniques.loops;

import java.util.ArrayList;
import java.util.List;

/**
 * Nested loops are like quicksand for your CPU. Even worse? Redundant calls to list.size() inside a loop.
 */
public class Loops {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }  // list.size() called EVERY iteration
    }
}
