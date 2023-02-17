package com.meawallet.parkingapp.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ParkingLot {
    Integer id;
    String name;
    Integer slotCount;
    Integer emptySlots;
}
