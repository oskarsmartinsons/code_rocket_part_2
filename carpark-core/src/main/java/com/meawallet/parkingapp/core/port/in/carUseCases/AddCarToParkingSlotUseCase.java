package com.meawallet.parkingapp.core.port.in.carUseCases;

import com.meawallet.parkingapp.domain.Car;

public interface AddCarToParkingSlotUseCase {
    void addCarToParkingSlotById(Car car, Integer slotId);

    void addCar(Car car, Integer slotId);
}
