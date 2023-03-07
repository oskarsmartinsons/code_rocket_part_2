package com.meawallet.parkingapp.core.port.in.carUseCases;

import com.meawallet.parkingapp.domain.Car;

import java.util.List;

public interface FindAllCarsUseCase {
    List<Car> findAllCars();
}
