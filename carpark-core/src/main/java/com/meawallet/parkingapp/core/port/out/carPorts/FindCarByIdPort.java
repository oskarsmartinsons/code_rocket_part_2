package com.meawallet.parkingapp.core.port.out.carPorts;

import com.meawallet.parkingapp.domain.Car;

import java.util.Optional;

public interface FindCarByIdPort {
    Optional<Car> findCarById(Integer Id);
}
