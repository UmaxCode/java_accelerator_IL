package org.umaxcode.designPatterns.creational.singleton;

public class LoggerDemo {

    public static void main(String[] args) {

        // without multithreading
        Logger logger1 = Logger.getInstance();
        logger1.log("Application started");
        logger1.debug("Debugging the application");
        logger1.error("An error occurred");

        Logger logger2 = Logger.getInstance();
        logger2.log("Application started");
        logger2.debug("Debugging the application");
        logger2.error("An error occurred");

        System.out.println(logger1 == logger2);

    }
}
