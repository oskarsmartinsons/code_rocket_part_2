package com.meawallet.parkingapp.in.converter.parkingSlot;

import com.meawallet.parkingapp.domain.ParkingSlot;
import com.meawallet.parkingapp.in.converter.car.CarToCreateCarInResponseConverter;
import com.meawallet.parkingapp.in.dto.parkingSlot.CreateParkingSlotInResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ParkingSlotToCreateParkingSlotInResponseConverter {

    private final CarToCreateCarInResponseConverter carToCreateCarInResponseConverter;
    public CreateParkingSlotInResponse convert (ParkingSlot parkingSlot) {
        return new CreateParkingSlotInResponse(
                parkingSlot.getId(),
                parkingSlot.getSlotNumber(),
                parkingSlot.isEmpty(),
                (parkingSlot.getCar() != null ? carToCreateCarInResponseConverter.convert(parkingSlot.getCar()) : null)
        );
    }
}
