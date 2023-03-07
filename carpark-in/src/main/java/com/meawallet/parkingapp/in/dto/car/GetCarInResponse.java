package com.meawallet.parkingapp.in.dto.car;

public record GetCarInResponse (
        Integer id,
        String registrationNumber,
        String carMake
){
}
