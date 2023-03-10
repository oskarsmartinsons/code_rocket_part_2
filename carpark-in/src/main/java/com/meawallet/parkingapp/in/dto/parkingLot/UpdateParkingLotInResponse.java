package com.meawallet.parkingapp.in.dto.parkingLot;

import com.meawallet.parkingapp.in.dto.parkingSlot.UpdateParkingSlotInResponse;

import java.util.List;

public record UpdateParkingLotInResponse(
        Integer id,
        String name,
        Integer slotCount,
        Integer emptySlots,
        List<UpdateParkingSlotInResponse> updateParkingSlotsInResponse
) {
}
