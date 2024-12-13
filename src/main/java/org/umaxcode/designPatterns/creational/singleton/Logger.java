package org.umaxcode.designPatterns.creational.singleton;

/**
 * A Singleton class for managing a single Logger instance.
 * <p>
 * This class ensures that only one Logger instance exists, which can be used across
 * the application to log messages consistently. It provides methods to write log
 * messages to the console or to a file (if implemented).
 * </p>
 */
public class Logger {

    /**
     * The single instance of the Logger.
     */
    private static volatile Logger instance;

    /**
     * Private constructor to prevent instantiation from outside the class.
     */
    private Logger() {
        // Private constructor to prevent instantiation
    }

    /**
     * Provides access to the single instance of the Logger.
     * <p>
     * Ensures that only one instance is created and shared across the application.
     * </p>
     *
     * @return The singleton instance of {@code Logger}.
     */
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                    System.out.println("Logger instance created by : " + Thread.currentThread().getName());
                }
            }
        }
        return instance;
    }

    /**
     * Logs a message to the console.
     *
     * @param message The message to be logged.
     */
    public void log(String message) {
        System.out.println("LOG: " + message);
    }

    /**
     * Logs an error message to the console.
     *
     * @param message The error message to be logged.
     */
    public void error(String message) {
        System.err.println("ERROR: " + message);
    }

    /**
     * Logs a debug message to the console.
     *
     * @param message The debug message to be logged.
     */
    public void debug(String message) {
        System.out.println("DEBUG: " + message);
    }
}
