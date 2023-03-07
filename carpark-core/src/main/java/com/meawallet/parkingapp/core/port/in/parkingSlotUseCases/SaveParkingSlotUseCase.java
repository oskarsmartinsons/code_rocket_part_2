package com.meawallet.parkingapp.core.port.in.parkingSlotUseCases;

import com.meawallet.parkingapp.domain.ParkingSlot;

public interface SaveParkingSlotUseCase {
    ParkingSlot saveParkingSlot(ParkingSlot parkingSlot);
}
