package com.umaxcode.bottom_up_integration_test.service;

import com.umaxcode.bottom_up_integration_test.domain.dto.UserDTO;
import com.umaxcode.bottom_up_integration_test.domain.entity.NewsFeed;
import com.umaxcode.bottom_up_integration_test.domain.entity.User;

import java.util.List;

public interface SocialMediaService {

    User findByUsername(String username);

    User registerUser(UserDTO request);

    List<NewsFeed> getUserFeed(Long userId);
}
