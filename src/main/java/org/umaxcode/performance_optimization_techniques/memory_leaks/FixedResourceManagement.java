package org.umaxcode.performance_optimization_techniques.memory_leaks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * The try-with-resources statement automatically closes the BufferedReader when done.
 * Prevents leaks even if an exception occurs.
 */
public class FixedResourceManagement {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader("example.txt"))) {
            System.out.println(reader.readLine()); // Read a line
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
