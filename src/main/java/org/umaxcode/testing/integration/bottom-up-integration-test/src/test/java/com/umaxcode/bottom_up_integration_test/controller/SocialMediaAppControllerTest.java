package com.umaxcode.bottom_up_integration_test.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.umaxcode.bottom_up_integration_test.domain.dto.UserDTO;
import com.umaxcode.bottom_up_integration_test.domain.entity.NewsFeed;
import com.umaxcode.bottom_up_integration_test.domain.entity.User;
import com.umaxcode.bottom_up_integration_test.repository.NewsFeedRepository;
import com.umaxcode.bottom_up_integration_test.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@TestPropertySource(
        locations = "classpath:application-test.properties")
class SocialMediaAppControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private NewsFeedRepository newsFeedRepository;

    @Autowired
    private UserRepository userRepository;

    private Long userId;

    @BeforeEach
    void setUp() {

        User user = User.builder()
                .username("test-username")
                .email("test@gmail.com")
                .password("test-password")
                .build();

        User savedUser = userRepository.save(user);
        userId = savedUser.getId();


        NewsFeed newsFeed1 = NewsFeed.builder()
                .title("Test Post 1")
                .content("This is the first test post")
                .timestamp(LocalDateTime.now())
                .postBy(user)
                .build();

        NewsFeed newsFeed2 = NewsFeed.builder()
                .title("Test Post 2")
                .content("This is the second test post")
                .timestamp(LocalDateTime.now())
                .postBy(user)
                .build();

        newsFeedRepository.saveAll(List.of(newsFeed1, newsFeed2));
    }

    @Test
    void registerUser_ShouldReturnCreatedUser() throws Exception {

        UserDTO userDTO = UserDTO.builder()
                .username("test-username")
                .email("test@gmail.com")
                .password("test-password")
                .build();

        mockMvc.perform(post("/social-media/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.username").value("test-username"))
                .andExpect(jsonPath("$.email").value("test@gmail.com"));
    }

    @Test
    void getUserByUserName_ShouldReturnUserDetails() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/social-media/users/{username}", "test-username")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("test-username"))
                .andExpect(jsonPath("$.email").value("test@gmail.com"));
    }

    @Test
    void getNewsFeeds_ShouldReturnListOfNewsFeeds() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/social-media/get-news-feeds/users/{id}", userId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].title").value("Test Post 1"))
                .andExpect(jsonPath("$[0].content").value("This is the first test post"))
                .andExpect(jsonPath("$[1].title").value("Test Post 2"))
                .andExpect(jsonPath("$[1].content").value("This is the second test post"));
    }
}