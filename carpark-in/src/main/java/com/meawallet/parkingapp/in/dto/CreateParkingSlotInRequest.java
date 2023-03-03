package com.meawallet.parkingapp.in.dto;

public record CreateParkingSlotInRequest(
        Integer slotNumber,
        boolean isEmpty,
        Integer parkingLotId,
        Integer carId
) {
}
