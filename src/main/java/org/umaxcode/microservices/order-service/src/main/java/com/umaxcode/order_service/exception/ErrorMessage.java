package com.umaxcode.order_service.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ErrorMessage {

    private String path;
    private String message;
    private LocalDateTime timestamp;
}
