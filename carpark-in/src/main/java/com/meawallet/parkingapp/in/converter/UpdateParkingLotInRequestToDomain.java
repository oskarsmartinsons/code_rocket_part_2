package com.meawallet.parkingapp.in.converter;

import com.meawallet.parkingapp.domain.ParkingLot;
import com.meawallet.parkingapp.in.dto.UpdateParkingLotInRequest;
import org.springframework.stereotype.Component;

@Component
public class UpdateParkingLotInRequestToDomain {
    public ParkingLot convert(UpdateParkingLotInRequest request) {
        return ParkingLot.builder()
                .name(request.name())
                .slotCount(request.slotCount())
                .emptySlots(request.emptySlots())
                .build();
    }
}