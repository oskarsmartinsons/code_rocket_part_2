package com.meawallet.parkingapp.core.port.in;

import com.meawallet.parkingapp.domain.ParkingLot;

public interface DeleteParkingLotUseCase {
    void deleteParkingLot(ParkingLot parkingLot);
}
