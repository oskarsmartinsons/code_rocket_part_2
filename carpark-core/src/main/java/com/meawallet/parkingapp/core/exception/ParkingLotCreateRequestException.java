package com.meawallet.parkingapp.core.exception;

public class ParkingLotCreateRequestException extends RuntimeException{
    public ParkingLotCreateRequestException(String message) {
        super(message);
    }
    public ParkingLotCreateRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
