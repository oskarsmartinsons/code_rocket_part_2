package com.meawallet.parkingapp.domain;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    Integer id;
    String registrationNumber;
    String carMake;
    ParkingSlot parkingSlot;
}
