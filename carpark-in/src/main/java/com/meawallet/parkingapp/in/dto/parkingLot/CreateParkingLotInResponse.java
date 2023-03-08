package com.meawallet.parkingapp.in.dto.parkingLot;

import com.meawallet.parkingapp.domain.ParkingSlot;

import java.util.List;

public record CreateParkingLotInResponse(
        Integer id,
        String name,
        Integer slotCount,
        Integer emptySlots,
        List<ParkingSlot> parkingSlots
) {
}
