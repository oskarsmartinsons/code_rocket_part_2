package com.meawallet.parkingapp.in.dto.parkingLot;

import com.meawallet.parkingapp.in.dto.parkingSlot.CreateParkingSlotInResponse;
import java.util.List;

public record CreateParkingLotInResponse(
        Integer id,
        String name,
        Integer slotCount,
        Integer emptySlots,
        List<CreateParkingSlotInResponse> createParkingSlotsInResponse
) {
}
