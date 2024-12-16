package com.umaxcode.top_down._integration_test.repository;

import com.umaxcode.top_down._integration_test.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitle(String title);
}
