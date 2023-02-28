package com.meawallet.parkingapp.in.converter;

import com.meawallet.parkingapp.domain.ParkingLot;
import com.meawallet.parkingapp.in.dto.CreateParkingLotRequest;
import org.springframework.stereotype.Component;

@Component
public class CreateParkingLotRequestToDomain {
    public ParkingLot convert(CreateParkingLotRequest request) {
        return ParkingLot.builder()
                .name(request.getName())
                .slotCount(request.getSlotCount())
                .emptySlots(request.getEmptySlots())
                .build();
    }
}
