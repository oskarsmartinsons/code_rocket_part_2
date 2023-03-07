package com.meawallet.parkingapp.repository.adapter.car;

import com.meawallet.parkingapp.core.port.out.carPorts.SaveCarPort;
import com.meawallet.parkingapp.domain.Car;
import com.meawallet.parkingapp.repository.converter.CarDomainToCarEntityConverter;
import com.meawallet.parkingapp.repository.converter.CarEntityToCarDomainConverter;
import com.meawallet.parkingapp.repository.repository.CarRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
//@Transactional
@AllArgsConstructor
public class SaveCarAdapter implements SaveCarPort {
    private final CarRepository carRepository;
    private final CarDomainToCarEntityConverter carDomainToCarEntityConverter;
    private final CarEntityToCarDomainConverter carEntityToCarDomainConverter;
    @Override
    public Car save(Car car) {
        var entity = carDomainToCarEntityConverter.convert(car);
        carRepository.save(entity);
        return carEntityToCarDomainConverter.convert(entity);
    }
}
