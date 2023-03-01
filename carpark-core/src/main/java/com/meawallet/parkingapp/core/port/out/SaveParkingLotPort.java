package com.meawallet.parkingapp.core.port.out;

import com.meawallet.parkingapp.domain.ParkingLot;

public interface SaveParkingLotPort {
    ParkingLot save(ParkingLot parkingLot);
}
