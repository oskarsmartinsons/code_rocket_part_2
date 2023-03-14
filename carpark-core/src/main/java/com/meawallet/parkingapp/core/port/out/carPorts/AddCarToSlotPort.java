package com.meawallet.parkingapp.core.port.out.carPorts;

import com.meawallet.parkingapp.domain.Car;

public interface AddCarToSlotPort {
    void addCarToParkingSlot(Car car, Integer slotId);
}
