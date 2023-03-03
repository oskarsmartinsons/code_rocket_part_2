package com.meawallet.parkingapp.core.port.in;

import com.meawallet.parkingapp.domain.ParkingSlot;

public interface SaveParkingSlotUseCase {
    ParkingSlot saveParkingSlot(ParkingSlot parkingSlot);
}
