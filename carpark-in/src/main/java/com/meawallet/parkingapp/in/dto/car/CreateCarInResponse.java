package com.meawallet.parkingapp.in.dto.car;

import com.meawallet.parkingapp.domain.ParkingSlot;

public record CreateCarInResponse (
        Integer id,
        String registrationNumber,
        String carMake
){
}
