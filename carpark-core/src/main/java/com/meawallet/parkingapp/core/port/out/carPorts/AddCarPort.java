package com.meawallet.parkingapp.core.port.out.carPorts;

import com.meawallet.parkingapp.domain.Car;

public interface AddCarPort {
    void addCarToParkingLot(Car car, Integer slotId);
}
