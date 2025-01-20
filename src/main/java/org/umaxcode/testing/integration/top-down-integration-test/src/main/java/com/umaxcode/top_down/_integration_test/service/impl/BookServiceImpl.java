package com.umaxcode.top_down._integration_test.service.impl;

import com.umaxcode.top_down._integration_test.domain.entity.Book;
import com.umaxcode.top_down._integration_test.repository.BookRepository;
import com.umaxcode.top_down._integration_test.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<Book> searchBooksByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
