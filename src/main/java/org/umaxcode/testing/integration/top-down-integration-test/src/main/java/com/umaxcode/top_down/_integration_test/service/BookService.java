package com.umaxcode.top_down._integration_test.service;

import com.umaxcode.top_down._integration_test.domain.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> searchBooksByTitle(String title);

    List<Book> getAllBooks();
}
