package com.meawallet.parkingapp.in.dto;

public record UpdateParkingSlotInRequest (
        Integer slotNumber,
        boolean isEmpty,
        Integer parkingLotId,
        Integer carId
){
}
