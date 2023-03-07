package com.meawallet.parkingapp.in.dto.parkingLot;

public record GetParkingLotInResponse(
        Integer id,
        String name,
        Integer slotCount,
        Integer emptySlots
) {
}
