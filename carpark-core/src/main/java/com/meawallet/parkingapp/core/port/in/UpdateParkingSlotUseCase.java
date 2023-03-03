package com.meawallet.parkingapp.core.port.in;

import com.meawallet.parkingapp.domain.ParkingSlot;

public interface UpdateParkingSlotUseCase {
    ParkingSlot updateParkingSlot(Integer id, ParkingSlot parkingSlot);
}
