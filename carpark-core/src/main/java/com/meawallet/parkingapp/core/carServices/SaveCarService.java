package com.meawallet.parkingapp.core.carServices;

import com.meawallet.parkingapp.core.port.in.carUseCases.SaveCarUseCase;
import com.meawallet.parkingapp.core.port.out.carPorts.SaveCarPort;
import com.meawallet.parkingapp.domain.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SaveCarService implements SaveCarUseCase {
    private final SaveCarPort saveCarPort;
    @Override
    public Car save(Car car) {
        return saveCarPort.save(car);
    }
}
