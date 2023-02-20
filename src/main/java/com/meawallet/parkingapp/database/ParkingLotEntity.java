package com.meawallet.parkingapp.database;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ParkingLotEntity {
    Integer id;
    String name;
    Integer slotCount;
    Integer emptySlots;
}
