package com.meawallet.parkingapp.in.dto;

public record CreateParkingSlotInResponse (
    Integer id,
    Integer slotNumber,
    boolean isEmpty,
    Integer parkingLotId,
    Integer carId
) {
}
