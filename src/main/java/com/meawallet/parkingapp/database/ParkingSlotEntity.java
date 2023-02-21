package com.meawallet.parkingapp.database;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ParkingSlotEntity {
    Integer id;
    boolean isEmpty;
    Integer parkingLotId;
    Integer carId;
}
