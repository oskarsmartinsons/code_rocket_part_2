package com.meawallet.parkingapp.in.converter;

import com.meawallet.parkingapp.domain.ParkingSlot;
import com.meawallet.parkingapp.in.dto.UpdateParkingSlotInRequest;
import org.springframework.stereotype.Component;

@Component
public class UpdateParkingSlotInRequestToDomain {
    public ParkingSlot convert(UpdateParkingSlotInRequest request) {
        return ParkingSlot.builder()
                .slotNumber(request.slotNumber())
                .isEmpty(request.isEmpty())
                .parkingLotId(request.parkingLotId())
                .carId(request.carId())
                .build();
    }
}
