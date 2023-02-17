package com.meawallet.parkingapp.dto;

import lombok.Value;

@Value
public class CreateParkingLotRequest {
    String name;
    Integer slotCount;
    Integer emptySlots;
}
