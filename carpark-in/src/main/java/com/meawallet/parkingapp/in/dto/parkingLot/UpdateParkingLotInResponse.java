package com.meawallet.parkingapp.in.dto.parkingLot;

public record UpdateParkingLotInResponse(
        Integer id,
        String name,
        Integer slotCount,
        Integer emptySlots
) {
}
