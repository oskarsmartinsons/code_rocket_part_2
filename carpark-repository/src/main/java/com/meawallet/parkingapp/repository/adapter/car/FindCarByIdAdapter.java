package com.meawallet.parkingapp.repository.adapter.car;

import com.meawallet.parkingapp.core.port.out.carPorts.FindCarByIdPort;
import com.meawallet.parkingapp.domain.Car;
import com.meawallet.parkingapp.repository.converter.CarEntityToCarDomainConverter;
import com.meawallet.parkingapp.repository.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class FindCarByIdAdapter implements FindCarByIdPort {
    private final CarRepository carRepository;
    private final CarEntityToCarDomainConverter carEntityToCarDomainConverter;
    @Override
    public Optional<Car> findCarById(Integer id) {
        return carRepository.findById(id)
                .map(carEntityToCarDomainConverter::convert);
    }
}
