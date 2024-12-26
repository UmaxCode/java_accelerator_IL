package com.umaxcode.springboot_security_oauth_actuator.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionResolver {


    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResponse unauthorizedExceptionHandler(AuthenticationException e, HttpServletRequest request) {
        return ErrorResponse.builder()
                .path(request.getRequestURI())
                .message("Invalid username or password")
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorResponse forbiddedExceptionHandler(AuthenticationException e, HttpServletRequest request) {
        return ErrorResponse.builder()
                .path(request.getRequestURI())
                .message("Not authorized to perform this action")
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse badRequestExceptionHandler(ServiceException e, HttpServletRequest request) {
        return ErrorResponse.builder()
                .path(request.getRequestURI())
                .message(e.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse notFoundExceptionHandler(Exception e, HttpServletRequest request) {
        return ErrorResponse.builder()
                .path(request.getRequestURI())
                .message(e.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }
}
