package org.umaxcode.advancedJavaFeatures.exercise2;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a library implementation that uses a non-static inner class to manage books.
 * <p>
 * Inner classes are commonly used when a class represents a helper component tightly
 * coupled with the outer class, and their usage outside the outer class is not intended.
 * </p>
 *
 * <h3>Types of Inner Classes in Java</h3>
 * <ol>
 *     <li><b>Non-static Inner Class:</b> A nested class that requires an instance of the outer class.</li>
 *     <li><b>Static Inner Class:</b> A nested class that does not depend on an instance of the outer class.</li>
 *     <li><b>Local Inner Class:</b> A class defined within a block (e.g., a method) and scoped to it.</li>
 *     <li><b>Anonymous Inner Class:</b> A one-time use class without a name, typically used to implement interfaces or extend classes.</li>
 * </ol>
 */

public class Library {

    private final String name;
    private final List<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public static void main(String[] args) {
        Library library = new Library("Amalitech Library");
        library.addBook("Spring Boot Essentials", "Maxwell Odoom");
        library.addBook("AWS Microservice", "Maxwell Odoom");
        library.listBooks();

        // To simplify the creation of the inner class, make it a static class.
        // This allows referencing it directly without instantiating the outer class.
        // Ex. Library.Book exBook = new Library.Book("x", "y")
        Library.Book book = library.new Book("Introduction to Angular", "Maxwell Odoom");
        System.out.println(book);
    }

    public void addBook(String title, String author) {
        Book book = new Book(title, author);
        books.add(book);
        System.out.println("Added book: " + book);
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("Books in " + name + ":");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    class Book {

        String title;
        String author;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        @Override
        public String toString() {
            return "Book [title=" + title + ", author=" + author + "]";
        }
    }
}
