package com.meawallet.parkingapp.in.dto.parkingLot;


public record CreateParkingLotInRequest(
    String name,
    Integer slotCount,
    Integer emptySlots
){
}
