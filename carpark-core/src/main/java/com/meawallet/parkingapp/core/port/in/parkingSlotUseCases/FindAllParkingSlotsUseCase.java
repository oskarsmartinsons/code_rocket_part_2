package com.meawallet.parkingapp.core.port.in.parkingSlotUseCases;

import com.meawallet.parkingapp.domain.ParkingSlot;

import java.util.List;

public interface FindAllParkingSlotsUseCase {
    List<ParkingSlot> findAllParkingSlots();
}
