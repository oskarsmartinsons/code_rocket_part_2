package com.meawallet.parkingapp.domain;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParkingSlot {
    private Integer id;
    private Integer slotNumber;
    private boolean isEmpty;
   // ParkingLot parkingLot;
   // Integer carId;
}
