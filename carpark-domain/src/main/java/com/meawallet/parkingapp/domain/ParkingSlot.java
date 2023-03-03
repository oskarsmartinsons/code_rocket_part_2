package com.meawallet.parkingapp.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ParkingSlot {
    Integer id;
    Integer slotNumber;
    boolean isEmpty;
    Integer parkingLotId;
    Integer carId;
}
