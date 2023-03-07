package com.meawallet.parkingapp.in.converter.parkingSlot;

import com.meawallet.parkingapp.domain.ParkingSlot;
import com.meawallet.parkingapp.in.dto.parkingSlot.CreateParkingSlotInRequest;
import org.springframework.stereotype.Component;

@Component
public class CreateParkingSlotInRequestToDomainConverter {
    public ParkingSlot convert(CreateParkingSlotInRequest request) {
        return ParkingSlot.builder()
                .slotNumber(request.slotNumber())
                .isEmpty(request.isEmpty())
                .parkingLotId(request.parkingLotId())
                .carId(request.carId())
                .build();
    }
}
