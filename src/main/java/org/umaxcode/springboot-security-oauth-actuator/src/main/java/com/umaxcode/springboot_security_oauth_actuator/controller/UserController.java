package com.umaxcode.springboot_security_oauth_actuator.controller;

import com.umaxcode.springboot_security_oauth_actuator.security.SecureUser;
import com.umaxcode.springboot_security_oauth_actuator.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class UserController {

    public final UserService userService;

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public String hello() {

        SecureUser secureUser = (SecureUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "hello " + secureUser.getUser().getUsername();
    }
}
