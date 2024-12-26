package com.umaxcode.springboot_security_oauth_actuator.service.impl;

import com.umaxcode.springboot_security_oauth_actuator.domain.dto.request.LoginUserDto;
import com.umaxcode.springboot_security_oauth_actuator.domain.dto.request.RegisterUserDto;
import com.umaxcode.springboot_security_oauth_actuator.domain.dto.response.LoginSuccessDto;
import com.umaxcode.springboot_security_oauth_actuator.domain.dto.response.RegisterSuccessDto;
import com.umaxcode.springboot_security_oauth_actuator.domain.entity.User;
import com.umaxcode.springboot_security_oauth_actuator.domain.enums.Role;
import com.umaxcode.springboot_security_oauth_actuator.repository.UserRepository;
import com.umaxcode.springboot_security_oauth_actuator.security.JWTService;
import com.umaxcode.springboot_security_oauth_actuator.security.SecureUser;
import com.umaxcode.springboot_security_oauth_actuator.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;

    public RegisterSuccessDto signup(RegisterUserDto request) {

        User user = User.builder()
                .username(request.username())
                .email(request.email())
                .role(Role.USER)
                .password(passwordEncoder.encode(request.password()))
                .build();

        User savedUser = userRepository.save(user);
        return RegisterSuccessDto.builder()
                .username(savedUser.getUsername())
                .email(savedUser.getEmail())
                .build();
    }

    public LoginSuccessDto authenticate(LoginUserDto request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );

        SecureUser userDetails = (SecureUser) authentication.getPrincipal();

        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("username", userDetails.getUser().getUsername());
        extraClaims.put("role", userDetails.getUser().getRole());
        String generatedAccessToken = jwtService.generateToken(extraClaims, userDetails);
        return LoginSuccessDto.builder()
                .accessToken(generatedAccessToken)
                .build();
    }
}
