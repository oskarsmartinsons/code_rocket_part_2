package com.meawallet.parkingapp.in.converter.car;

import com.meawallet.parkingapp.domain.Car;
import com.meawallet.parkingapp.in.dto.car.CreateCarInRequest;
import org.springframework.stereotype.Component;

@Component
public class CreateCarInRequestToDomainConverter {
    public Car convert(CreateCarInRequest request) {
        return Car.builder()
                .registrationNumber(request.registrationNumber())
                .carMake(request.carMake())
                .build();
    }
}
