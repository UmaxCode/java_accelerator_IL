package com.umaxcode.bottom_up_integration_test.controller;

import com.umaxcode.bottom_up_integration_test.domain.dto.NewsFeedDTO;
import com.umaxcode.bottom_up_integration_test.domain.dto.UserDTO;
import com.umaxcode.bottom_up_integration_test.domain.entity.NewsFeed;
import com.umaxcode.bottom_up_integration_test.domain.entity.User;
import com.umaxcode.bottom_up_integration_test.service.SocialMediaService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/social-media")
@RequiredArgsConstructor
@Transactional
public class SocialMediaAppController {

    private final SocialMediaService socialMediaService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO registerUser(@RequestBody UserDTO userDTO) {

        User user = socialMediaService.registerUser(userDTO);

        return UserDTO.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }

    @GetMapping("/users/{username}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getUserByUserName(@PathVariable("username") String username) {

        User user = socialMediaService.findByUsername(username);

        return UserDTO.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }

    @GetMapping("/get-news-feeds/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<NewsFeedDTO> getNewsFeeds(@PathVariable("id") Long id) {

        List<NewsFeed> userFeed = socialMediaService.getUserFeed(id);

        return userFeed.stream().map(
                feed -> NewsFeedDTO.builder()
                        .title(feed.getTitle())
                        .content(feed.getContent())
                        .timestamp(feed.getTimestamp())
                        .build()
        ).toList();
    }
}
