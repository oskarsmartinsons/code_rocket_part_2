package com.meawallet.parkingapp.in.dto.car;

public record UpdateCarInRequest (
        String registrationNumber,
        String carMake
){
}
