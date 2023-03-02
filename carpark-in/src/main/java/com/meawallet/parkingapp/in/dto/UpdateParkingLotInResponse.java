package com.meawallet.parkingapp.in.dto;

public record UpdateParkingLotInResponse(
        Integer id,
        String name,
        Integer slotCount,
        Integer emptySlots
) {
}
