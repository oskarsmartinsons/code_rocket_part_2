package com.meawallet.parkingapp.in.dto;


public record CreateParkingLotInRequest(
    String name,
    Integer slotCount,
    Integer emptySlots
){
}
