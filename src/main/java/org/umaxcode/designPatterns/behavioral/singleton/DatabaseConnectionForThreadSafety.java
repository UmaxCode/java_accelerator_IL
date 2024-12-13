package org.umaxcode.designPatterns.behavioral.singleton;

/**
 * A Singleton class to manage a single database connection instance.
 * <p>
 * This class ensures that only one instance of the database connection is created
 * and shared across all thread. This approach shines in a multithreaded environment.
 * </p>
 */

public class DatabaseConnectionForThreadSafety {

    private static final Object lock = new Object();
    // Volatile ensures visibility of changes to instance across threads
    private static volatile DatabaseConnectionForThreadSafety connection;

    private DatabaseConnectionForThreadSafety() {
        // Initialize any necessary resources here
    }

    public static DatabaseConnectionForThreadSafety getConnection() {
        if (connection == null) {
            synchronized (lock) {
                if (connection == null) {
                    connection = new DatabaseConnectionForThreadSafety();
                    System.out.println("Database connection established by thread :-: " + Thread.currentThread().getName());
                }
            }
        }

        return connection;
    }


    @Override
    public String toString() {
        return "Database Connection :-: " + Thread.currentThread().getName();
    }
}
