package org.umaxcode.javaConcurrency.exercise4;

public class DeadLockResolutionExample {

    private static final Object resource1 = new Object(); // First shared resource
    private static final Object resource2 = new Object(); // Second shared resource

    public static void main(String[] args) {
        // Thread 1: Locks resource1, then resource2
        Thread thread1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread().getName() + " locked resource1");
                try {
                    Thread.sleep(100); // Simulate some work with resource1
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                synchronized (resource2) {
                    System.out.println(Thread.currentThread().getName() + " locked resource2");
                }
            }
        });

        // Thread 2: Also locks resource1, then resource2
        Thread thread2 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread().getName() + " locked resource1");
                try {
                    Thread.sleep(100); // Simulate some work with resource1
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                synchronized (resource2) {
                    System.out.println(Thread.currentThread().getName() + " locked resource2");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
