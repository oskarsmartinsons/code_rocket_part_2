package com.meawallet.parkingapp.domain;

import lombok.*;

import java.util.List;

@Data
@Builder (toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class ParkingLot {
    Integer id;
    String name;
    Integer slotCount;
    Integer emptySlots;
    List<ParkingSlot> parkingSlots;
    Guard guard;
}
