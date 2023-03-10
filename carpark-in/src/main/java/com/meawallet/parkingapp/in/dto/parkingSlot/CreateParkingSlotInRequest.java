package com.meawallet.parkingapp.in.dto.parkingSlot;

import com.meawallet.parkingapp.domain.ParkingLot;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jdk.jfr.BooleanFlag;

public record CreateParkingSlotInRequest(
        @Positive
        Integer slotNumber,
        boolean isEmpty
) {
}
