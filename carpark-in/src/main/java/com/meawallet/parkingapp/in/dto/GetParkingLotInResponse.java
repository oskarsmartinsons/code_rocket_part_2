package com.meawallet.parkingapp.in.dto;

public record GetParkingLotInResponse(
        Integer id,
        String name,
        Integer slotCount,
        Integer emptySlots
) {
}
