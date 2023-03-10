package com.meawallet.parkingapp.core.port.out.parkingLotPorts;

import com.meawallet.parkingapp.domain.ParkingLot;

public interface UpdateParkingLotPort {
    ParkingLot update(ParkingLot parkingLot);
}
