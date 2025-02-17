package org.umaxcode.performance_optimization_techniques.memory_leaks;

import java.util.HashMap;
import java.util.UUID;

/**
 * Java’s garbage collector isn’t psychic.
 * Unclosed resources, static collections,
 * and rogue listeners can turn your app into a zombie.
 */
public class StaticHashMapLeak {

    private static final HashMap<String, String> cache = new HashMap<>();


    public static void main(String[] args) throws InterruptedException {


         // The garbage collector cannot reclaim memory because the static reference persists for the application's lifetime.
         // If used in a long-running app (like a web server), memory usage will keep growing → eventually leading to OutOfMemoryError

        for (int i = 0; i < 1_000_000; i++) {  // Adding 1M entries
            cache.put(UUID.randomUUID().toString(), "Memory Leak");
        }
        System.out.println("Cache size: " + cache.size());

        // Simulating app running indefinitely
        Thread.sleep(10000);

    }
}
