package org.umaxcode.performance_optimization_techniques.string_concatenation;

/**
 * The StringBuilder approach modifies the same object, avoiding unnecessary object creation
 */
public class StringConcatenationFix {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10_000; i++) {
            builder.append("Java"); // Modifies the existing StringBuilder object
        }
        String result = builder.toString();
//        System.out.println("Results: " + result);
        long endTime = System.currentTimeMillis();
        System.out.println("StringBuilder Time: " + (endTime - startTime) + "ms");
    }
}
