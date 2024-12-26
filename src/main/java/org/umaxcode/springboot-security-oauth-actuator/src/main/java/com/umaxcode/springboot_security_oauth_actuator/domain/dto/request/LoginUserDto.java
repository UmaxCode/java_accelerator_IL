package com.umaxcode.springboot_security_oauth_actuator.domain.dto.request;

import lombok.Builder;

@Builder
public record LoginUserDto(
        String email,
        String password
) {
}
