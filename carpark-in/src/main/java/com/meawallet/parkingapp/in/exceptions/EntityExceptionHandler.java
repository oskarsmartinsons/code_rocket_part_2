package com.meawallet.parkingapp.in.exceptions;

import com.meawallet.parkingapp.core.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EntityExceptionHandler {
    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<Object> handleParkingLotNotFoundException (EntityNotFoundException entityNotFoundException) {
        EntityException entityException = new EntityException(
                entityNotFoundException.getMessage(),
                entityNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(entityException, HttpStatus.NOT_FOUND);
    }
}
