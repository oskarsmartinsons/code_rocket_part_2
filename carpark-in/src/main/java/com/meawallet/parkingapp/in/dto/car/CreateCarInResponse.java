package com.meawallet.parkingapp.in.dto.car;

public record CreateCarInResponse (
        Integer id,
        String registrationNumber,
        String carMake
){
}
