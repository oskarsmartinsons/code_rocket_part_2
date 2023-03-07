package com.meawallet.parkingapp.core.port.in.carUseCases;

import com.meawallet.parkingapp.domain.Car;

public interface SaveCarUseCase {
    Car save(Car car);
}
