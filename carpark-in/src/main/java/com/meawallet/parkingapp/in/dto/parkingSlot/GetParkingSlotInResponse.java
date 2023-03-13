package com.meawallet.parkingapp.in.dto.parkingSlot;

import com.meawallet.parkingapp.domain.Car;

public record GetParkingSlotInResponse (
        Integer id,
        Integer slotNumber,
        boolean isEmpty,
        Car car
){
}
