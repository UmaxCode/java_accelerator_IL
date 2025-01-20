package com.umaxcode.bottom_up_integration_test.service;

import com.umaxcode.bottom_up_integration_test.domain.dto.UserDTO;
import com.umaxcode.bottom_up_integration_test.domain.entity.NewsFeed;
import com.umaxcode.bottom_up_integration_test.domain.entity.User;
import com.umaxcode.bottom_up_integration_test.repository.NewsFeedRepository;
import com.umaxcode.bottom_up_integration_test.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class SocialMediaServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private NewsFeedRepository newsFeedRepository;

    @InjectMocks
    private SocialMediaServiceImpl socialMediaService;


    @Test
    void findByUsername_ShouldReturnsUserIfExist() {

        String username = "test-username";

        User user = User.builder()
                .email("test@gmail.com")
                .username("test-username")
                .password("test-password")
                .build();

        when(userRepository.findByUsername(username)).thenReturn(Optional.of(user));

        User foundUser = socialMediaService.findByUsername(username);

        assertNotNull(foundUser);
        assertEquals("test-username", foundUser.getUsername());
        assertEquals("test-password", foundUser.getPassword());
        verify(userRepository, times(1)).findByUsername("test-username");
    }

    @Test
    void findByUsername_ShouldThrowExceptionWhenUserNotFound() {

        when(userRepository.findByUsername("unknown_username")).thenReturn(Optional.empty());

        IllegalStateException exception = assertThrows(IllegalStateException.class, () ->
                socialMediaService.findByUsername("unknown_username"));

        assertEquals("User not found", exception.getMessage());
        verify(userRepository, times(1)).findByUsername("unknown_username");
    }

    @Test
    void registerUser_ShouldSaveAndReturnsTheSavedUser() {

        User newUser = User.builder()
                .username("test-username")
                .email("test@gmail.com")
                .password("test-password")
                .build();

        UserDTO userRequest = UserDTO.builder()
                .username("test-username")
                .email("test@gmail.com")
                .password("test-password")
                .build();


        when(userRepository.save(any(User.class))).thenReturn(newUser);

        User registeredUser = socialMediaService.registerUser(userRequest);

        assertNotNull(registeredUser);
        assertEquals("test-username", registeredUser.getUsername());
        assertEquals("test@gmail.com", registeredUser.getEmail());
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void getUserFeed_ShouldReturnsUserNewsFeed() {

        long userId = 1L;

        User user = User.builder()
                .id(userId)
                .username("test-username")
                .email("test@gmail.com")
                .password("test-password")
                .build();

        List<NewsFeed> newsFeeds = List.of(
                NewsFeed.builder()
                        .title("title 1")
                        .content("content 1")
                        .timestamp(LocalDateTime.now())
                        .postBy(user)
                        .build(),

                NewsFeed.builder()
                        .title("title 2")
                        .content("content 2")
                        .timestamp(LocalDateTime.now())
                        .postBy(user)
                        .build()
        );

        when(newsFeedRepository.findNewsFeedByPostBy_Id(userId)).thenReturn(newsFeeds);

        List<NewsFeed> result = socialMediaService.getUserFeed(userId);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("title 1", result.get(0).getTitle());
        assertEquals("content 1", result.get(0).getContent());
        assertEquals("title 2", result.get(1).getTitle());
        assertEquals("content 2", result.get(1).getContent());
        verify(newsFeedRepository, times(1)).findNewsFeedByPostBy_Id(userId);
    }

}