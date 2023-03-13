package com.meawallet.parkingapp.in.converter.parkingSlot;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import com.meawallet.parkingapp.domain.Car;
import com.meawallet.parkingapp.domain.ParkingSlot;
import com.meawallet.parkingapp.in.converter.car.CreateCarInRequestToDomainConverter;
import com.meawallet.parkingapp.in.dto.car.CreateCarInRequest;
import com.meawallet.parkingapp.in.dto.parkingSlot.CreateParkingSlotInRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class CreateParkingSlotInRequestToDomainConverter {
    private final CreateCarInRequestToDomainConverter createCarInRequestToDomainConverter;
    public ParkingSlot convert(CreateParkingSlotInRequest request) {

        Optional<Car> car = request.createCarInRequest()
                .map(createCarInRequestToDomainConverter::convert);

        return ParkingSlot.builder()
                .slotNumber(request.slotNumber())
                .isEmpty(request.isEmpty())
                .car(car.orElse(null))
                .build();
    }
}
