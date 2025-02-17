package org.umaxcode.performance_optimization_techniques.memory_leaks;

import java.util.UUID;
import java.util.WeakHashMap;

public class FixedHashMap {

    // WeakHashMap allows garbage collection of unused keys.
    private static final WeakHashMap<String, String> cache = new WeakHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1_000_000; i++) {
            cache.put(UUID.randomUUID().toString(), "No Memory Leak");
        }
        System.out.println("Cache size: " + cache.size());

        System.gc(); // Requesting garbage collection
        Thread.sleep(10000);
    }
}
