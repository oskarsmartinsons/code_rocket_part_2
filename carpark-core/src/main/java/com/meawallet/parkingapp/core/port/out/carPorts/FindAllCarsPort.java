package com.meawallet.parkingapp.core.port.out.carPorts;

import com.meawallet.parkingapp.domain.Car;

import java.util.List;

public interface FindAllCarsPort {
    List<Car> getAll();
}
