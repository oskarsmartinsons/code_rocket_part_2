package com.meawallet.parkingapp.in.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        String errorMessage = "There was a problem - insert,update,delete results in violation of an integrity constrain.";
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        String errorMessage = "Validation error(s): ";
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errorMessage += fieldError.getField() + " " + fieldError.getDefaultMessage() + ", ";
        }
        errorMessage = errorMessage.substring(0, errorMessage.length() - 2);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }
}
