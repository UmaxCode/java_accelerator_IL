package org.umaxcode.advancedJavaFeatures.exercise5;

import java.util.concurrent.ConcurrentHashMap;

public class SimpleInMemoryCache<K, V> {

    private final ConcurrentHashMap<K, V> cache;

    public SimpleInMemoryCache() {
        this.cache = new ConcurrentHashMap<>();
    }

    public static void main(String[] args) {

        SimpleInMemoryCache<String, String> cache = new SimpleInMemoryCache<>();

        // Put entries into the cache
        cache.put("key1", "value1");
        cache.put("key2", "value2");

        System.out.println("Get key1: " + cache.get("key1")); // Output: value1

        System.out.println("Get key2: " + cache.get("key2")); // Output: value2

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
