package com.meawallet.parkingapp.core.port.out.parkingLotPorts;

import com.meawallet.parkingapp.domain.ParkingLot;

public interface DeleteParkingLotPort {
    void deleteById (Integer id);
}
