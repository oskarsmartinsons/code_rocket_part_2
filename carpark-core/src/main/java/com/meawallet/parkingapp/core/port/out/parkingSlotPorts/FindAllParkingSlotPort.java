package com.meawallet.parkingapp.core.port.out.parkingSlotPorts;

import com.meawallet.parkingapp.domain.ParkingSlot;

import java.util.List;

public interface FindAllParkingSlotPort {
    List<ParkingSlot> getAll();
}
