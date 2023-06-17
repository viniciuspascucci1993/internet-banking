package com.vinicius.internetbanking.controller.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    private List<FieldMessage> errors = new ArrayList<FieldMessage>();

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addError(String fieldName, String message) {
        errors.add(new FieldMessage(fieldName, message));
    }
}
