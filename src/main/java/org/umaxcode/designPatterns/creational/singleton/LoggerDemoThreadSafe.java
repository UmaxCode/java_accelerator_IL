package org.umaxcode.designPatterns.creational.singleton;

public class LoggerDemoThreadSafe {

    public static void main(String[] args) {
        // with multithreading
        Runnable task = () -> {
            Logger singleton = Logger.getInstance();
            singleton.log("Application started : " + Thread.currentThread().getName());
        };

        // Use multiple threads to test thread safety
        Thread thread3 = new Thread(task);
        thread3.setName("Thread 3");

        Thread thread4 = new Thread(task);
        thread4.setName("Thread 4");

        thread3.start();
        thread4.start();

        // you will notice that the "Logger instance created." will be
        // printed only once even though we are using multiple threads
    }
}
