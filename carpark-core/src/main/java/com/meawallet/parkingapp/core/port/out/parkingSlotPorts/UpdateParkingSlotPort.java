package com.meawallet.parkingapp.core.port.out.parkingSlotPorts;

import com.meawallet.parkingapp.domain.ParkingSlot;

public interface UpdateParkingSlotPort {
    void update(ParkingSlot parkingSlot);
}
