package com.meawallet.parkingapp.repository.converter;

import com.meawallet.parkingapp.domain.Car;
import com.meawallet.parkingapp.repository.entity.CarEntity;
import org.springframework.stereotype.Component;

@Component
public class CarEntityToCarDomainConverter {
    public Car convert (CarEntity carEntity) {
        return Car.builder()
                .id(carEntity.getId())
                .registrationNumber(carEntity.getRegistrationNumber())
                .carMake(carEntity.getCarMake())
                .build();
    }
}
