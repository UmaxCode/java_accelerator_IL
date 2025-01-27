package com.umaxcode.crud_app_with_jenkins.controller;


import com.umaxcode.crud_app_with_jenkins.model.Book;
import com.umaxcode.crud_app_with_jenkins.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@RequestBody Book book) {
        return this.bookService.addBook(book);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getBookById(@PathVariable("id") String bookId) {
        return this.bookService.getBook(bookId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAllBooks() {
        return this.bookService.getBooks();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBookById(@PathVariable("id") String bookId) {
        this.bookService.deleteBook(bookId);
    }

}
