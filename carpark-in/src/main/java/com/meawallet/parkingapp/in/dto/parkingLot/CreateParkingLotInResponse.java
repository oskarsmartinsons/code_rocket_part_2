package com.meawallet.parkingapp.in.dto.parkingLot;

public record CreateParkingLotInResponse(
        Integer id,
        String name,
        Integer slotCount,
        Integer emptySlots
) {
}
