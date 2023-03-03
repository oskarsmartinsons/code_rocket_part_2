package com.meawallet.parkingapp.in.dto;

public record UpdateParkingLotInRequest (
    String name,
    Integer slotCount,
    Integer emptySlots
){
}
