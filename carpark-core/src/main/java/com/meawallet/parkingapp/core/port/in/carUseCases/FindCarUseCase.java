package com.meawallet.parkingapp.core.port.in.carUseCases;

import com.meawallet.parkingapp.domain.Car;

import java.util.Optional;

public interface FindCarUseCase {
    Car findCarById(Integer id);
}
