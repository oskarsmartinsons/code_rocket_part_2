package com.meawallet.parkingapp.in.dto.parkingLot;

import com.meawallet.parkingapp.in.dto.parkingSlot.GetParkingSlotInResponse;

import java.util.List;

public record GetParkingLotInResponse(
        Integer id,
        String name,
        Integer slotCount,
        Integer emptySlots,
        List<GetParkingSlotInResponse> parkingSlotsInResponse
) {
}
