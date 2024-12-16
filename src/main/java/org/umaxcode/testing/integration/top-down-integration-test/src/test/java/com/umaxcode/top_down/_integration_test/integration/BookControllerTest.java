package com.umaxcode.top_down._integration_test.integration;


import com.umaxcode.top_down._integration_test.domain.entity.Book;
import com.umaxcode.top_down._integration_test.domain.entity.User;
import com.umaxcode.top_down._integration_test.repository.BookRepository;
import com.umaxcode.top_down._integration_test.repository.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
@Transactional
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeAll
    static void beforeAll(@Autowired BookRepository bookRepository, @Autowired UserRepository userRepository) {

        List<Book> books = List.of(
                Book.builder()
                        .title("title 1")
                        .author("author 1")
                        .build(),
                Book.builder()
                        .title("title 1")
                        .author("author 2")
                        .build(),
                Book.builder()
                        .title("title 2")
                        .author("author 2")
                        .build()
        );

        bookRepository.saveAll(books);


        List<User> users = List.of(
                User.builder()
                        .email("alice@gmail.com")
                        .name("Alice")
                        .build(),
                User.builder()
                        .email("boo@gmail.com")
                        .name("Bob")
                        .build()
        );

        userRepository.saveAll(users);
    }

    @Test
    void searchBooks_ShouldReturnBooksWithASpecificTitle() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/library/books-spec")
                        .param("title", "title 1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].title").value("title 1"))
                .andExpect(jsonPath("$[0].author").value("author 1"))
                .andExpect(jsonPath("$[1].title").value("title 1"))
                .andExpect(jsonPath("$[1].author").value("author 2"))
        ;
    }


    @Test
    void getAllBooks_ShouldReturnAllBooks() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/library/books-all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3))
                .andExpect(jsonPath("$[0].title").value("title 1"))
                .andExpect(jsonPath("$[0].author").value("author 1"))
                .andExpect(jsonPath("$[1].title").value("title 1"))
                .andExpect(jsonPath("$[1].author").value("author 2"))
                .andExpect(jsonPath("$[2].title").value("title 2"))
                .andExpect(jsonPath("$[2].author").value("author 2"));
    }

    @Test
    void getUsers_ShouldReturnUsers() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/library/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Alice"))
                .andExpect(jsonPath("$[0].email").value("alice@gmail.com"))
                .andExpect(jsonPath("$[1].name").value("Bob"))
                .andExpect(jsonPath("$[1].email").value("boo@gmail.com"));
    }

    @Test
    void findAUser_ShouldFindAUserById() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/library/users/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Alice"))
                .andExpect(jsonPath("$.email").value("alice@gmail.com"));
    }
}
