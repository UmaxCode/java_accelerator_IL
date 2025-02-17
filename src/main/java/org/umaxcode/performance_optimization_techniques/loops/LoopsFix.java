package org.umaxcode.performance_optimization_techniques.loops;

import java.util.ArrayList;
import java.util.List;

public class LoopsFix {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int size = list.size();
        for (int i = 0; i < size; i++) {
            System.out.println(list.get(i));
        }

        // For better performance use Enhance for-loop
        //for (String item : list) { ... } Enhanced for-loop
    }
}
