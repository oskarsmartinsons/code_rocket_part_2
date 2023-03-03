package com.meawallet.parkingapp.in.dto;

public record GetParkingSlotInResponse (
        Integer id,
        Integer slotNumber,
        boolean isEmpty,
        Integer parkingLotId,
        Integer carId
){
}
