package com.umaxcode.springboot_security_oauth_actuator.controller;

import com.umaxcode.springboot_security_oauth_actuator.domain.dto.request.LoginUserDto;
import com.umaxcode.springboot_security_oauth_actuator.domain.dto.request.RegisterUserDto;
import com.umaxcode.springboot_security_oauth_actuator.domain.dto.response.LoginSuccessDto;
import com.umaxcode.springboot_security_oauth_actuator.domain.dto.response.RegisterSuccessDto;
import com.umaxcode.springboot_security_oauth_actuator.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<RegisterSuccessDto> signup(@RequestBody RegisterUserDto request) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(authenticationService.signup(request));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginSuccessDto> login(@RequestBody LoginUserDto request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
