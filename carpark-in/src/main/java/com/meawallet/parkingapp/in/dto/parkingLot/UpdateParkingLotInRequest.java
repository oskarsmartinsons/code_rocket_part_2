package com.meawallet.parkingapp.in.dto.parkingLot;

import com.meawallet.parkingapp.in.dto.parkingSlot.UpdateParkingSlotInRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

import java.util.List;
import java.util.Optional;

public record UpdateParkingLotInRequest (
        @NotBlank
        @Length(min = 1, max = 20)
        String name,
        @Positive
        Integer slotCount,
        @Positive
        Integer emptySlots,
        Optional<List<UpdateParkingSlotInRequest>> updateParkingSlotsInRequests

){
}
