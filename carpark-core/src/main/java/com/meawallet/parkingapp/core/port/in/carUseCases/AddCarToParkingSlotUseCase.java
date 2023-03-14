package com.meawallet.parkingapp.core.port.in.carUseCases;

import com.meawallet.parkingapp.domain.Car;

public interface AddCarToParkingSlotUseCase {
    void addCarInParkingSlot(Car car, Integer slotId);
}
