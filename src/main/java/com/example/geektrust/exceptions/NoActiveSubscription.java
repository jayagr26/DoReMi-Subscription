package com.example.geektrust.exceptions;

public class NoActiveSubscription extends RuntimeException {
    public NoActiveSubscription() {
        super();
    }
    
    public NoActiveSubscription(String msg) {
        super(msg);
    }
}
