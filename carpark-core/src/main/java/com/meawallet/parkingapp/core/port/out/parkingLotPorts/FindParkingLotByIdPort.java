package com.meawallet.parkingapp.core.port.out.parkingLotPorts;

import com.meawallet.parkingapp.domain.ParkingLot;

import java.util.Optional;


public interface FindParkingLotByIdPort {
    Optional<ParkingLot> findById (Integer id);
}
