package com.meawallet.parkingapp.in.dto.parkingLot;

public record UpdateParkingLotInRequest (
    String name,
    Integer slotCount,
    Integer emptySlots
){
}
