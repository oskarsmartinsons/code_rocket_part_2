package com.meawallet.parkingapp.core.port.out.parkingLotPorts;

import com.meawallet.parkingapp.domain.ParkingLot;

import java.util.List;

public interface FindAllParkingLotsPort {
    List<ParkingLot> getAll();
}
