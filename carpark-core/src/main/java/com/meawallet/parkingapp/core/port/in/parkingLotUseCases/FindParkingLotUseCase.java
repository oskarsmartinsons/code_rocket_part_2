package com.meawallet.parkingapp.core.port.in.parkingLotUseCases;

import com.meawallet.parkingapp.exception.EntityNotFoundException;
import com.meawallet.parkingapp.domain.ParkingLot;

public interface FindParkingLotUseCase {
    ParkingLot findParkingLotById(Integer id) throws EntityNotFoundException;
}
