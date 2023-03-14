package com.meawallet.parkingapp.repository.adapter.car;

import com.meawallet.parkingapp.core.port.out.carPorts.SaveCarPort;
import com.meawallet.parkingapp.domain.Car;
import com.meawallet.parkingapp.repository.converter.CarDomainToCarEntityConverter;
import com.meawallet.parkingapp.repository.converter.CarEntityToCarDomainConverter;
import com.meawallet.parkingapp.repository.entity.CarEntity;
import com.meawallet.parkingapp.repository.repository.CarRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;
@Slf4j
@Component
@Transactional
@AllArgsConstructor
public class SaveCarAdapter implements SaveCarPort {
    private final CarRepository carRepository;

    private final ConversionService conversionService;
    private final CarEntityToCarDomainConverter carEntityToCarDomainConverter;

    @Override
    public Car save(Car car) {
        var entity = conversionService.convert(car, CarEntity.class);
        carRepository.save(entity);
        log.debug("CAR: {} saved successfully", entity);

        return carEntityToCarDomainConverter.convert(entity);
    }
}
