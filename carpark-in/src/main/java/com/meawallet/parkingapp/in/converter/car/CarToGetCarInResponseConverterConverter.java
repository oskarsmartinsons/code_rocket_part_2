package com.meawallet.parkingapp.in.converter.car;

import com.meawallet.parkingapp.domain.Car;
import com.meawallet.parkingapp.in.dto.car.GetCarInResponse;
import org.springframework.stereotype.Component;

@Component
public class CarToGetCarInResponseConverterConverter {
    public GetCarInResponse convert(Car car) {
        return new GetCarInResponse(
                car.getId(),
                car.getRegistrationNumber(),
                car.getCarMake()
        );
    }
}
