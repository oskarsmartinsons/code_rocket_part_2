package com.meawallet.parkingapp.core.port.out;

import com.meawallet.parkingapp.domain.ParkingLot;

public interface SaveParkingLotPort {
    void save(ParkingLot parkingLot);
}
