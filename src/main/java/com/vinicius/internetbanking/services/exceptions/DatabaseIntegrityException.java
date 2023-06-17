package com.vinicius.internetbanking.services.exceptions;

public class DatabaseIntegrityException extends RuntimeException {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    public DatabaseIntegrityException( String message ) {
        super(message);
    }
}
