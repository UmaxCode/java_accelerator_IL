package com.umaxcode.bottom_up_integration_test.service;

import com.umaxcode.bottom_up_integration_test.domain.dto.UserDTO;
import com.umaxcode.bottom_up_integration_test.domain.entity.NewsFeed;
import com.umaxcode.bottom_up_integration_test.domain.entity.User;
import com.umaxcode.bottom_up_integration_test.repository.NewsFeedRepository;
import com.umaxcode.bottom_up_integration_test.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SocialMediaServiceImpl implements SocialMediaService {

    private final UserRepository userRepository;
    private final NewsFeedRepository newsFeedRepository;

    @Override
    public User findByUsername(String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }

        throw new IllegalStateException("User not found");
    }

    @Override
    public User registerUser(UserDTO request) {

        User userInstance = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
        return userRepository.save(userInstance);
    }

    @Override
    public List<NewsFeed> getUserFeed(Long userId) {
        return newsFeedRepository.findNewsFeedByPostBy_Id(userId);
    }
}
