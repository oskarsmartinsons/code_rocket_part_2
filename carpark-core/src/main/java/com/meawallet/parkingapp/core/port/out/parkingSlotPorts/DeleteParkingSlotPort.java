package com.meawallet.parkingapp.core.port.out.parkingSlotPorts;

import com.meawallet.parkingapp.domain.ParkingSlot;

public interface DeleteParkingSlotPort {
    void deleteById(Integer id);
}
