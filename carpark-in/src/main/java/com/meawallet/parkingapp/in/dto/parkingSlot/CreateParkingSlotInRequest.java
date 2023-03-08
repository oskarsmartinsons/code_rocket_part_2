package com.meawallet.parkingapp.in.dto.parkingSlot;

import com.meawallet.parkingapp.domain.ParkingLot;

public record CreateParkingSlotInRequest(
        Integer slotNumber,
        boolean isEmpty
     //   ParkingLot parkingLot,
     //   Integer carId
) {
}
