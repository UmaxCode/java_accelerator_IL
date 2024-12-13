package org.umaxcode.designPatterns.behavioral.singleton;

public class SingletonDemo {

    public static void main(String[] args) {

        // example to demonstrate
        Runnable task = () -> {
            DatabaseConnection connection = DatabaseConnection.getConnection();
            System.out.println(connection);
        };

        // Use multiple threads to test thread safety
        Thread thread1 = new Thread(task);
        thread1.setName("Thread 1");

        Thread thread2 = new Thread(task);
        thread2.setName("Thread 2");

        thread1.start();
        thread2.start();
    }
}
