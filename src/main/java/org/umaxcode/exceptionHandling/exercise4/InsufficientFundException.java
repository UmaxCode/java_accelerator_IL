package org.umaxcode.exceptionHandling.exercise4;

public class InsufficientFundException extends RuntimeException {
    public InsufficientFundException(String message) {
        super(message);
    }
}
