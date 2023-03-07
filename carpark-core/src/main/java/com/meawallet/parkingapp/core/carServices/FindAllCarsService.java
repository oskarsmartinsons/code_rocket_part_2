package com.meawallet.parkingapp.core.carServices;

import com.meawallet.parkingapp.core.port.in.carUseCases.FindAllCarsUseCase;
import com.meawallet.parkingapp.core.port.in.carUseCases.FindCarUseCase;
import com.meawallet.parkingapp.core.port.out.carPorts.FindAllCarsPort;
import com.meawallet.parkingapp.domain.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class FindAllCarsService implements FindAllCarsUseCase {
    private final FindAllCarsPort findAllCarsPort;

    @Override
    public List<Car> findAllCars() {
        return findAllCarsPort.getAll();
    }
}
