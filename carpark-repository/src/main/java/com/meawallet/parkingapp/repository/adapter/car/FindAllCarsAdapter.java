package com.meawallet.parkingapp.repository.adapter.car;

import com.meawallet.parkingapp.core.port.out.carPorts.FindAllCarsPort;
import com.meawallet.parkingapp.domain.Car;
import com.meawallet.parkingapp.repository.converter.CarEntityToCarDomainConverter;
import com.meawallet.parkingapp.repository.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class FindAllCarsAdapter implements FindAllCarsPort {
    private final CarRepository carRepository;
    private final CarEntityToCarDomainConverter carEntityToCarDomainConverter;
    @Override
    public List<Car> getAll() {
        return carRepository.findAll().stream()
                .map(carEntityToCarDomainConverter::convert)
                .collect(Collectors.toList());
    }
}
