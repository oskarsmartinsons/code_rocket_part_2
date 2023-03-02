package com.meawallet.parkingapp.in.dto;

import lombok.Value;

@Value
public class UpdateParkingLotInResponse {
    Integer id;
    String name;
    Integer slotCount;
    Integer emptySlots;
}
