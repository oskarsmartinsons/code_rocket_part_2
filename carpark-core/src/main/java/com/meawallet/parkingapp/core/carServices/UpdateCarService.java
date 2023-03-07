package com.meawallet.parkingapp.core.carServices;

import com.meawallet.parkingapp.core.port.in.carUseCases.UpdateCarUseCase;
import com.meawallet.parkingapp.core.port.out.carPorts.FindCarByIdPort;
import com.meawallet.parkingapp.core.port.out.carPorts.UpdateCarPort;
import com.meawallet.parkingapp.domain.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UpdateCarService implements UpdateCarUseCase {
    private final UpdateCarPort updateCarPort;
    private final FindCarByIdPort findCarByIdPort;
    @Override
    public void updateCar(Car car) {
        findCarByIdPort.findCarById(car.getId())
                        .orElseThrow(()->new IllegalArgumentException("Car not found"));
        updateCarPort.update(car);
    }
}
