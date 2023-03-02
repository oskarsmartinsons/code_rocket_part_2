package com.meawallet.parkingapp.in.dto;

public record UpdateParkingLotInRequest (
  //  Integer id,
    String name,
    Integer slotCount,
    Integer emptySlots
){
}
