package com.meawallet.parkingapp.in.dto.parkingSlot;

public record UpdateParkingSlotInRequest (
        Integer slotNumber,
        boolean isEmpty,
        Integer parkingLotId,
        Integer carId
){
}
