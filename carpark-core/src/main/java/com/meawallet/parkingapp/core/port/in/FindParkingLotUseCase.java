package com.meawallet.parkingapp.core.port.in;

import com.meawallet.parkingapp.domain.ParkingLot;

public interface FindParkingLotUseCase {
    ParkingLot getParkingLot (Integer id);
}
