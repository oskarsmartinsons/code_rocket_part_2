package com.meawallet.parkingapp.core.port.in;

import com.meawallet.parkingapp.domain.ParkingSlot;

public interface FindParkingSlotUseCase {
    ParkingSlot findParkingSlotById(Integer id);
}
