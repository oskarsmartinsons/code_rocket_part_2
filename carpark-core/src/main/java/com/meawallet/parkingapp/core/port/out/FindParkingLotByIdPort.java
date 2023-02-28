package com.meawallet.parkingapp.core.port.out;

import com.meawallet.parkingapp.domain.ParkingLot;

import java.util.Optional;


public interface FindParkingLotByIdPort {
    Optional<ParkingLot> findById (Integer id);
}
