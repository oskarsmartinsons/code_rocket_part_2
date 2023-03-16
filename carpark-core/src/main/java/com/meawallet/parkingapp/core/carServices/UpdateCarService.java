package com.meawallet.parkingapp.core.carServices;

import com.meawallet.parkingapp.core.exception.EntityNotFoundException;
import com.meawallet.parkingapp.core.port.in.carUseCases.UpdateCarUseCase;
import com.meawallet.parkingapp.core.port.out.carPorts.FindCarByIdPort;
import com.meawallet.parkingapp.core.port.out.carPorts.UpdateCarPort;
import com.meawallet.parkingapp.domain.Car;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
@Slf4j
@Component
@AllArgsConstructor
public class UpdateCarService implements UpdateCarUseCase {
    private final UpdateCarPort updateCarPort;
    private final FindCarByIdPort findCarByIdPort;
    @Override
    public void updateCar(Car car) {
        findCarByIdPort.findCarById(car.getId())
                .orElseThrow(()->new EntityNotFoundException("Car with id " + car.getId() + " not found for update"));
        log.debug("CAR found by id: {}", car.getId());
        updateCarPort.update(car);
    }
}
