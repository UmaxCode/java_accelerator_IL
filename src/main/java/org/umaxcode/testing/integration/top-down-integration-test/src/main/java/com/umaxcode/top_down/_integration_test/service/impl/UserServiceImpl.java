package com.umaxcode.top_down._integration_test.service.impl;

import com.umaxcode.top_down._integration_test.domain.entity.User;
import com.umaxcode.top_down._integration_test.repository.UserRepository;
import com.umaxcode.top_down._integration_test.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }

        throw new IllegalStateException("User not found");
    }

}
