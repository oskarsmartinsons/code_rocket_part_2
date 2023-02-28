package com.meawallet.parkingapp.core.port.out;

import com.meawallet.parkingapp.domain.ParkingLot;

import java.util.List;

public interface ShowParkingLotsPort {
    List<ParkingLot> getAll();
}
