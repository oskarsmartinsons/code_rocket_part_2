package com.meawallet.parkingapp.repository.converter;

import com.meawallet.parkingapp.repository.entity.ParkingSlotEntity;
import com.meawallet.parkingapp.domain.ParkingSlot;
import org.springframework.stereotype.Component;

@Component
public class ParkingSlotEntityToParkingSlotDomain {
    public ParkingSlot convert(ParkingSlotEntity entity) {
        return ParkingSlot.builder()
                .id(entity.getId())
                .isEmpty(entity.isEmpty())
                .parkingLotId(entity.getParkingLotId())
                .build();
    }
}
