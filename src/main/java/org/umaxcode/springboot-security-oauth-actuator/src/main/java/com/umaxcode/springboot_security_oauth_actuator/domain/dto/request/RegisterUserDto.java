package com.umaxcode.springboot_security_oauth_actuator.domain.dto.request;

import lombok.Builder;

@Builder
public record RegisterUserDto(
        String username,
        String email,
        String password
) {
}
