package com.mikkelgud.claim;

public class InvalidClaimRegistrationException extends Exception {
    public InvalidClaimRegistrationException(String message) {
        super(message);
    }
}