package com.meawallet.parkingapp.core.carServices;

import com.meawallet.parkingapp.core.exception.EntityNotFoundException;
import com.meawallet.parkingapp.core.port.in.carUseCases.FindCarUseCase;
import com.meawallet.parkingapp.core.port.out.carPorts.FindCarByIdPort;
import com.meawallet.parkingapp.domain.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FindCarService implements FindCarUseCase {
    private final FindCarByIdPort findCarByIdPort;
    @Override
    public Car findCarById(Integer id) {
        return findCarByIdPort.findCarById(id)
                .orElseThrow(()->new EntityNotFoundException("Car not found with id: " + id));
    }
}
