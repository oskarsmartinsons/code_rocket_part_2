package com.meawallet.parkingapp.in.converter.car;

import com.meawallet.parkingapp.domain.Car;
import com.meawallet.parkingapp.in.dto.car.CreateCarInResponse;
import org.springframework.stereotype.Component;

@Component
public class CarToCreateCarInResponseConverter {
    public CreateCarInResponse convert(Car car) {
        return new CreateCarInResponse(
                car.getId(),
                car.getRegistrationNumber(),
                car.getCarMake()
        );
    }
}
