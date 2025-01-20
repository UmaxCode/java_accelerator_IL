package org.umaxcode.advancedJavaFeatures.exercise5;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleInMemoryCache<K, V> {

    private final ConcurrentHashMap<K, V> cache;

    public SimpleInMemoryCache() {
        this.cache = new ConcurrentHashMap<>();
    }

    public static void main(String[] args) {

        SimpleInMemoryCache<String, String> cache = new SimpleInMemoryCache<>();

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // Task to add entries to the cache
        Runnable writerTask = () -> {
            for (int i = 1; i <= 10; i++) {
                String key = "key" + i;
                String value = "value" + i;
                cache.put(key, value);
                System.out.println(Thread.currentThread().getName() + " put: " + key + " -> " + value);
            }
        };

        // Task to read entries from the cache
        Runnable readerTask = () -> {
            for (int i = 1; i <= 10; i++) {
                String key = "key" + i;
                String value = cache.get(key);
                System.out.println(Thread.currentThread().getName() + " get: " + key + " -> " + value);
            }
        };

        // Task to remove entries from the cache
        Runnable removerTask = () -> {
            for (int i = 1; i <= 10; i++) {
                String key = "key" + i;
                cache.remove(key);
                System.out.println(Thread.currentThread().getName() + " removed: " + key);
            }
        };

        // Submit multiple tasks to the executor service
        executorService.submit(writerTask);
        executorService.submit(readerTask);
        executorService.submit(writerTask);
        executorService.submit(readerTask);
        executorService.submit(removerTask);

        // Shutdown the executor service after tasks are completed
        executorService.shutdown();

    }

    // Adds a key-value pair to the cache
    public void put(K key, V value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Key and Value cannot be null");
        }
        cache.put(key, value);
    }

    // Gets a value from the cache based on the key
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        return cache.get(key);
    }

    //Removes a key value pair from the cache based on the key
    public void remove(K key) {
        cache.remove(key);
    }

    // Checks if the cache contains a specific key
    public boolean containsKey(K key) {
        return cache.containsKey(key);
    }

    // Clears the entire cache
    public void clear() {
        cache.clear();
    }

    // Gets the current size of the cache
    public int size() {
        return cache.size();
    }
}
