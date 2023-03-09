package com.meawallet.parkingapp.in.dto.parkingLot;

import com.meawallet.parkingapp.domain.ParkingSlot;
import com.meawallet.parkingapp.in.dto.parkingSlot.CreateParkingSlotInResponse;

import java.util.List;
import java.util.Optional;

public record CreateParkingLotInResponse(
        Integer id,
        String name,
        Integer slotCount,
        Integer emptySlots,
        List<CreateParkingSlotInResponse> createParkingSlotsInResponse
) {
}
