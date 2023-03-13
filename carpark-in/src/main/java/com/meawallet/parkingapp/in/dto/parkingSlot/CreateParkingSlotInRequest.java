package com.meawallet.parkingapp.in.dto.parkingSlot;

import com.meawallet.parkingapp.in.dto.car.CreateCarInRequest;
import jakarta.validation.constraints.Positive;
import java.util.Optional;

public record CreateParkingSlotInRequest(
        @Positive
        Integer slotNumber,
        boolean isEmpty,
        Optional<CreateCarInRequest> createCarInRequest
) {
}
