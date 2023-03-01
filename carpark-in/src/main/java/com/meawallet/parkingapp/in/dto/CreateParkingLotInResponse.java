package com.meawallet.parkingapp.in.dto;

public record CreateParkingLotInResponse(
        Integer id,
        String name,
        Integer slotCount,
        Integer emptySlots
) {
}
