package com.meawallet.parkingapp.in.converter.parkingLot;

import com.meawallet.parkingapp.domain.ParkingLot;
import com.meawallet.parkingapp.domain.ParkingSlot;
import com.meawallet.parkingapp.in.dto.parkingLot.CreateParkingLotInRequest;
import org.springframework.stereotype.Component;

@Component
public class CreateParkingLotInRequestToDomainConverter {
    public ParkingLot convert(CreateParkingLotInRequest request) {
        return ParkingLot.builder()
                .name(request.name())
                .slotCount(request.slotCount())
                .emptySlots(request.emptySlots())
                .parkingSlots(request.parkingSlots())
                .build();
    }
}
