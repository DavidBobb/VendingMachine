package com.sda.vendingmachine.exceptions;

public class NotSufficientChangeException extends RuntimeException {
    public NotSufficientChangeException(String message) {
        super(message);
    }
}
