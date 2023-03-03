package com.meawallet.parkingapp.core.port.out;

import com.meawallet.parkingapp.domain.ParkingSlot;

public interface DeleteParkingSlotPort {
    void delete(ParkingSlot parkingSlot);
}
