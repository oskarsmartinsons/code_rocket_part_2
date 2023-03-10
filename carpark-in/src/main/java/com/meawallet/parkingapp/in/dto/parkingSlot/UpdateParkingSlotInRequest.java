package com.meawallet.parkingapp.in.dto.parkingSlot;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record UpdateParkingSlotInRequest (
        Integer id,
        @Positive
        Integer slotNumber,
        boolean isEmpty
){
}
