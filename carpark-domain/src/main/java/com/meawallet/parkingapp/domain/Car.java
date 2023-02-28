package com.meawallet.parkingapp.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Car {
    Integer id;
    String registrationNumber;
    String carMake;
}
