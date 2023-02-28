package com.meawallet.parkingapp.repository.converter;

import com.meawallet.parkingapp.repository.entity.ParkingLotEntity;
import com.meawallet.parkingapp.domain.ParkingLot;
import org.springframework.stereotype.Component;

@Component
public class ParkingLotEntityToParkingLotDomain {
    public ParkingLot convert (ParkingLotEntity entity) {
        return ParkingLot.builder()
                .id(entity.getId())
                .name(entity.getName())
                .slotCount(entity.getSlotCount())
                .emptySlots(entity.getEmptySlots())
                .build();
    }
}
