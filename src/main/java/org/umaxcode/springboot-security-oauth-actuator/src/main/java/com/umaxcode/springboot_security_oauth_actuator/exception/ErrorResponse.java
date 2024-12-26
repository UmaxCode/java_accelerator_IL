package com.umaxcode.springboot_security_oauth_actuator.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ErrorResponse {

    private String path;
    private String message;
    private LocalDateTime timestamp;
}
