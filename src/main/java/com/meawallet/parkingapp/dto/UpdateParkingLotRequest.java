package com.meawallet.parkingapp.dto;

import lombok.Value;

@Value
public class UpdateParkingLotRequest {
    Integer id;
    String name;
    Integer slotCount;
    Integer emptySlots;
}
