package org.umaxcode.designPatterns.behavioral.singleton;


/**
 * A Singleton class to manage a single database connection instance.
 * <p>
 * This class ensures that only one instance of the database connection is created
 * and shared across. This approach will fail to create only one instance globally
 * in a multithreaded environment.
 * </p>
 */
public class DatabaseConnection {

    private static DatabaseConnection connection;

    private DatabaseConnection() {
        // to private instantiation through the constructor
        // and achieve lazy instantiation
    }

    public static DatabaseConnection getConnection() {

        if (connection == null) {
            connection = new DatabaseConnection();
            System.out.println("Database connection established by thread :-: " + Thread.currentThread().getName());
        }
        return connection;
    }

    @Override
    public String toString() {
        return "Database Connection :-: " + Thread.currentThread().getName();
    }
}
