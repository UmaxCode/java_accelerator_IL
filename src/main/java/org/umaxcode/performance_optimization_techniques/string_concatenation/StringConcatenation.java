package org.umaxcode.performance_optimization_techniques.string_concatenation;

/**
 * Every + operation creates a new String object, leading to excessive memory
 * usage and time overhead due to garbage collection.
 */
public class StringConcatenation {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        String str = "";
        for (int i = 0; i < 10_000; i++) {
            str += "Java"; // Creates a new String object in every iteration
        }

        long endTime = System.currentTimeMillis();
//        System.out.println("Result: " + str);
        System.out.println("String Concatenation Time: " + (endTime - startTime) + "ms");
    }

}
