package com.meawallet.parkingapp.in.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class EntityException {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;

}
