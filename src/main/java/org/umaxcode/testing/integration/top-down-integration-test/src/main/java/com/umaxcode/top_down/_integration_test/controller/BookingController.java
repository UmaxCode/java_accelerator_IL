package com.umaxcode.top_down._integration_test.controller;

import com.umaxcode.top_down._integration_test.domain.entity.Book;
import com.umaxcode.top_down._integration_test.domain.entity.User;
import com.umaxcode.top_down._integration_test.service.BookService;
import com.umaxcode.top_down._integration_test.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
@RequiredArgsConstructor
public class BookingController {

    private final UserService userService;
    private final BookService bookService;

    @GetMapping("/books-spec")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> searchBooksByTitle(@RequestParam(name = "title") String title) {
        return bookService.searchBooksByTitle(title);
    }

    @GetMapping("/books-all")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User findAUser(@PathVariable(value = "id") Long userId) {
        return userService.getUserById(userId);
    }
}
