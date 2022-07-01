package com.example.geektrust.exceptions;

public class AlreadyExistingTopupException extends RuntimeException {
    public AlreadyExistingTopupException() {
        super();
    }

    public AlreadyExistingTopupException(String msg) {
        super(msg);
    }
}
