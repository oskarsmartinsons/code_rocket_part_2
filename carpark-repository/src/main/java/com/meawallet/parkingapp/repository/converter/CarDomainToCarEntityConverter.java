package com.meawallet.parkingapp.repository.converter;

import com.meawallet.parkingapp.domain.Car;
import com.meawallet.parkingapp.repository.entity.CarEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CarDomainToCarEntityConverter implements Converter<Car, CarEntity> {

    @Override
    public CarEntity convert(Car car) {
        return CarEntity.builder()
                .id(car.getId())
                .registrationNumber(car.getRegistrationNumber())
                .carMake(car.getCarMake())
                .build();
    }
}
