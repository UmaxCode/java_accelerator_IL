package com.umaxcode.crud_app_with_jenkins.service;

import com.umaxcode.crud_app_with_jenkins.model.Book;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {

    private final Map<String, Book> books;

    public BookService() {
        this.books = new HashMap<>();
    }

    public Book addBook(Book book) {

        String generatedBookId = UUID.randomUUID().toString();
        book.setId(generatedBookId);
        this.books.put(generatedBookId, book);
        return book;
    }

    public Book getBook(String bookId) {
        return this.books.get(bookId);
    }

    public List<Book> getBooks() {
        return new ArrayList<>(this.books.values());
    }

    public void deleteBook(String bookId) {
        this.books.remove(bookId);
    }
}
