package com.meawallet.parkingapp.core.port.out.carPorts;

import com.meawallet.parkingapp.domain.Car;

public interface SaveCarPort{
    Car save(Car car);
}
