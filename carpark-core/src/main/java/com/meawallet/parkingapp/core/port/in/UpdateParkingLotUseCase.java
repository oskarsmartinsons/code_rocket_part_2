package com.meawallet.parkingapp.core.port.in;

import com.meawallet.parkingapp.domain.ParkingLot;

public interface UpdateParkingLotUseCase {
    ParkingLot updateParkingLot(Integer id, ParkingLot parkingLot);
}
