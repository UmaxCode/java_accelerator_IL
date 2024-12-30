package com.umaxcode.product_service.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class ErrorMessage {

    private String path;
    private Object message;
    private LocalDateTime timestamp;
}
