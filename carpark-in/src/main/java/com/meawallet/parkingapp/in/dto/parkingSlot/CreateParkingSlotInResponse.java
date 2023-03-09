package com.meawallet.parkingapp.in.dto.parkingSlot;

public record CreateParkingSlotInResponse (
    Integer id,
    Integer slotNumber,
    boolean isEmpty
) {
}
