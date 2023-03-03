package com.meawallet.parkingapp.in.dto;

public record UpdateParkingSlotInResponse (
        Integer id,
        Integer slotNumber,
        boolean isEmpty,
        Integer parkingLotId,
        Integer carId
){
}
