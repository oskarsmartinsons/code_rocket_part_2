package com.meawallet.parkingapp.core.port.out;

import com.meawallet.parkingapp.domain.ParkingSlot;

import java.util.Optional;

public interface FindParkingSlotByIdPort {
    Optional<ParkingSlot> findById(Integer id);
}
