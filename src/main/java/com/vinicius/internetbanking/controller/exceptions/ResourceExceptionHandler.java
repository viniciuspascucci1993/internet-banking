package com.vinicius.internetbanking.controller.exceptions;

import com.vinicius.internetbanking.services.exceptions.InvalidDepositException;
import com.vinicius.internetbanking.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFoundException(ResourceNotFoundException e , HttpServletRequest request ) {

        HttpStatus status = HttpStatus.NOT_FOUND;

        StandardError standardError = new StandardError();
        standardError.setTimeStamp(Instant.now());
        standardError.setStatus(status.value());
        standardError.setError("Resource Not Found");
        standardError.setMessage(e.getMessage());
        standardError.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(standardError);
    }

    // MethodArgumentNotValidException
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> validation( MethodArgumentNotValidException e , HttpServletRequest request ) {

        HttpStatus status = HttpStatus.BAD_REQUEST;

        ValidationError validationError = new ValidationError();
        validationError.setTimeStamp(Instant.now());
        validationError.setStatus(status.value());
        validationError.setError("Valtidation Exception");
        validationError.setMessage("Requisição Mal-Sucedida");
        validationError.setPath(request.getRequestURI());

        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            validationError.addError(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return ResponseEntity.status(status).body(validationError);
    }

    @ExceptionHandler(InvalidDepositException.class)
    public ResponseEntity<StandardError> invalidDepositoException(InvalidDepositException e , HttpServletRequest request ) {

        HttpStatus status = HttpStatus.BAD_REQUEST;

        StandardError standardError = new StandardError();
        standardError.setTimeStamp(Instant.now());
        standardError.setStatus(status.value());
        standardError.setError("Invalid Deposito Bad Request");
        standardError.setMessage(e.getMessage());
        standardError.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(standardError);
    }
}
