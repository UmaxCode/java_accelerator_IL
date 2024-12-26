package com.umaxcode.springboot_security_oauth_actuator.exception;

public class ServiceException extends RuntimeException {

    public ServiceException(String message) {
        super(message);
    }
}
