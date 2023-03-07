package com.meawallet.parkingapp.core.port.in.parkingLotUseCases;

import com.meawallet.parkingapp.domain.ParkingLot;

import java.util.List;

public interface FindAllParkingLotsUseCase {
    List<ParkingLot> findAllParkingLots();
}
