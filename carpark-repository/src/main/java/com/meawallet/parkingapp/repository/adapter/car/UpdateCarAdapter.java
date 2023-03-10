package com.meawallet.parkingapp.repository.adapter.car;

import com.meawallet.parkingapp.core.port.out.carPorts.UpdateCarPort;
import com.meawallet.parkingapp.domain.Car;
import com.meawallet.parkingapp.repository.converter.CarDomainToCarEntityConverter;
import com.meawallet.parkingapp.repository.repository.CarRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Slf4j
@Component
@AllArgsConstructor
public class UpdateCarAdapter implements UpdateCarPort {
    private final CarRepository carRepository;
    private final CarDomainToCarEntityConverter carDomainToCarEntityConverter;
    @Override
    public void update(Car car) {
        var entity = carDomainToCarEntityConverter.convert(car);
        carRepository.save(entity);
        log.debug("CAR entity updated successfully: {}", entity);
    }
}
