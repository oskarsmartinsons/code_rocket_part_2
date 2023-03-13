package com.meawallet.parkingapp.in.dto.parkingSlot;

import com.meawallet.parkingapp.domain.Car;
import com.meawallet.parkingapp.in.dto.car.CreateCarInResponse;

public record CreateParkingSlotInResponse (
    Integer id,
    Integer slotNumber,
    boolean isEmpty,
    CreateCarInResponse createCarInResponse
) {
}
