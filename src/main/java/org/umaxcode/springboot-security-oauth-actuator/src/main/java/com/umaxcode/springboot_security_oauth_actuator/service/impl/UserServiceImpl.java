package com.umaxcode.springboot_security_oauth_actuator.service.impl;

import com.umaxcode.springboot_security_oauth_actuator.domain.entity.User;
import com.umaxcode.springboot_security_oauth_actuator.repository.UserRepository;
import com.umaxcode.springboot_security_oauth_actuator.security.SecureUser;
import com.umaxcode.springboot_security_oauth_actuator.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService, UserService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> optionalUser = userRepository.findByEmail(username);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return SecureUser.builder()
                    .user(user)
                    .build();
        }

        throw new UsernameNotFoundException("User not found");
    }
}
