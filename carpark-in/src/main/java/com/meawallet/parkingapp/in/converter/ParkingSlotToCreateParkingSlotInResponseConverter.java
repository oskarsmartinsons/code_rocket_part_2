package com.meawallet.parkingapp.in.converter;

import com.meawallet.parkingapp.domain.ParkingSlot;
import com.meawallet.parkingapp.in.dto.CreateParkingSlotInResponse;
import org.springframework.stereotype.Component;

@Component
public class ParkingSlotToCreateParkingSlotInResponseConverter {
    public CreateParkingSlotInResponse convert (ParkingSlot parkingSlot) {
        return new CreateParkingSlotInResponse(
                parkingSlot.getId(),
                parkingSlot.getSlotNumber(),
                parkingSlot.isEmpty(),
                parkingSlot.getParkingLotId(),
                parkingSlot.getCarId()
        );
    }
}
