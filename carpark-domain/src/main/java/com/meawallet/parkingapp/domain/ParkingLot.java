package com.meawallet.parkingapp.domain;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class ParkingLot {
    Integer id;
    String name;
    Integer slotCount;
    Integer emptySlots;
    List<ParkingSlot> parkingSlots;
}
