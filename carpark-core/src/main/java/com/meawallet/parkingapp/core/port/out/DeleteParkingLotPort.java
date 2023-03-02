package com.meawallet.parkingapp.core.port.out;

import com.meawallet.parkingapp.core.port.in.DeleteParkingLotUseCase;
import com.meawallet.parkingapp.domain.ParkingLot;

import java.util.Optional;

public interface DeleteParkingLotPort {
    void delete (ParkingLot parkingLot);
}
