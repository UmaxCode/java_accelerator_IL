package org.umaxcode.performance_optimization_techniques.memory_leaks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * The BufferedReader holds system resources (file handles, memory) until explicitly closed.
 * If the file is large or accessed frequently, many file handles could be left open → Resource exhaustion.
 */
public class UnclosedResourceLeak {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("example.txt"));
        System.out.println(reader.readLine()); // Read a line
        // Oops! Forgot to close the reader
    }

}
