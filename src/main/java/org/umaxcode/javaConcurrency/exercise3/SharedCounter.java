package org.umaxcode.javaConcurrency.exercise3;

public class SharedCounter {

    private int counter = 0;

    /**
     * Increments the counter in a thread-safe manner.
     */
    public void increment() {
        synchronized (this) { // Synchronized block to ensure thread safety
            counter++;
            System.out.println(Thread.currentThread().getName() + " incremented counter to: " + counter);
        }
    }

    public int getCounter() {
        return counter;
    }
}
