package com.meawallet.parkingapp.core.port.out.parkingLotPorts;

import com.meawallet.parkingapp.domain.ParkingSlot;

import java.util.List;

public interface GetParkingSlotsForParkingLotPort {
    List<ParkingSlot> findParkingSlotsByParkingLotId(Integer parkingLotId);
}
