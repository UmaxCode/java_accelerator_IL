package org.umaxcode.javaConcurrency.exercise3;

public class SharedCounterDemo {

    public static void main(String[] args) {

        SharedCounter sharedCounter = new SharedCounter();


        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                sharedCounter.increment();
                try {
                    Thread.sleep(100); // Simulate some delay
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        // Create multiple threads that access the shared counter
        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");

        // Start threads
        thread1.start();
        thread2.start();

        // Wait for threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Final counter value: " + sharedCounter.getCounter());
    }
}
