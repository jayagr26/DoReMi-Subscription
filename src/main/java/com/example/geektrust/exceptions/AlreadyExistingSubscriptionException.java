package com.example.geektrust.exceptions;

public class AlreadyExistingSubscriptionException extends RuntimeException {
    public AlreadyExistingSubscriptionException() {
        super();
    }

    public AlreadyExistingSubscriptionException(String msg) {
        super(msg);
    }
}
