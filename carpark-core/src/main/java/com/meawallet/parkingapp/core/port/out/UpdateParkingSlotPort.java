package com.meawallet.parkingapp.core.port.out;

import com.meawallet.parkingapp.domain.ParkingSlot;

public interface UpdateParkingSlotPort {
    ParkingSlot update(ParkingSlot parkingSlot);
}
