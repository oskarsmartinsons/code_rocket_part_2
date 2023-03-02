package com.meawallet.parkingapp.in.converter;

import com.meawallet.parkingapp.domain.ParkingLot;
import com.meawallet.parkingapp.in.dto.CreateParkingLotInRequest;
import org.springframework.stereotype.Component;

@Component
public class CreateParkingLotInRequestToDomain {
    public ParkingLot convert(CreateParkingLotInRequest request) {
        return ParkingLot.builder()
                .name(request.name())
                .slotCount(request.slotCount())
                .emptySlots(request.emptySlots())
                .build();
    }
}
