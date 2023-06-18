package com.vinicius.internetbanking.services.exceptions;

public class InvalidDepositException extends RuntimeException {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    public InvalidDepositException(String message) {
        super(message);
    }
}
