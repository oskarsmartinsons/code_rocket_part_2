package com.meawallet.parkingapp.in.dto;

import lombok.Value;

@Value
public class CreateParkingLotRequest {
    String name;
    Integer slotCount;
    Integer emptySlots;
}
