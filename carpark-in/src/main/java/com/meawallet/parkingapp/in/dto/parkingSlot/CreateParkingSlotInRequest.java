package com.meawallet.parkingapp.in.dto.parkingSlot;

public record CreateParkingSlotInRequest(
        Integer slotNumber,
        boolean isEmpty,
        Integer parkingLotId,
        Integer carId
) {
}
