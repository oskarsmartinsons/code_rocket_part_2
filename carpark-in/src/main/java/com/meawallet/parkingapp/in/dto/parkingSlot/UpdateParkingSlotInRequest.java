package com.meawallet.parkingapp.in.dto.parkingSlot;

import com.meawallet.parkingapp.in.dto.car.UpdateCarInRequest;
import jakarta.validation.constraints.Positive;

public record UpdateParkingSlotInRequest (
        Integer id,
        @Positive
        Integer slotNumber,
        boolean isEmpty
){
}
