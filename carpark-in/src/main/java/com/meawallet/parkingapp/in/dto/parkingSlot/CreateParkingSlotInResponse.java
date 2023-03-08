package com.meawallet.parkingapp.in.dto.parkingSlot;

import com.meawallet.parkingapp.domain.ParkingLot;
import com.meawallet.parkingapp.domain.ParkingSlot;

public record CreateParkingSlotInResponse (
    Integer id,
    Integer slotNumber,
    boolean isEmpty
  //  ParkingLot parkingLot,
   // Integer carId
) {
}
