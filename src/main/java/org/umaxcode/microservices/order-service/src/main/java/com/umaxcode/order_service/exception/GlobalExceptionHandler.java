package com.umaxcode.order_service.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage exception(Exception e, HttpServletRequest request) {

        return ErrorMessage.builder()
                .path(request.getRequestURI())
                .message(e.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }
}
