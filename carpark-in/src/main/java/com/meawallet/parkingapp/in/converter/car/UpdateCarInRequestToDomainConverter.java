package com.meawallet.parkingapp.in.converter.car;

import com.meawallet.parkingapp.domain.Car;
import com.meawallet.parkingapp.in.dto.car.UpdateCarInRequest;
import org.springframework.stereotype.Component;

@Component
public class UpdateCarInRequestToDomainConverter {
    public Car convert(UpdateCarInRequest request, Integer id) {
        return Car.builder()
                .id(id)
                .registrationNumber(request.registrationNumber())
                .carMake(request.carMake())
                .build();
    }
}
