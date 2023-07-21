package com.vinicius.internetbanking.services.exceptions;

public class ExpectedDateHasNotYetArrivedException extends RuntimeException {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    public ExpectedDateHasNotYetArrivedException(String message) {
        super(message);
    }
}