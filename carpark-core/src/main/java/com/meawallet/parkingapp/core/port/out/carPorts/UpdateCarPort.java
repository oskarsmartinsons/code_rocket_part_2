package com.meawallet.parkingapp.core.port.out.carPorts;

import com.meawallet.parkingapp.domain.Car;

public interface UpdateCarPort {
    void update(Car car);
}
