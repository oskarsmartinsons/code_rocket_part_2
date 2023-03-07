package com.meawallet.parkingapp.repository.converter;

import com.meawallet.parkingapp.domain.ParkingLot;
import com.meawallet.parkingapp.repository.entity.ParkingLotEntity;
import org.springframework.stereotype.Component;

@Component
public class ParkingLotDomainToParkingLotEntity {
    public ParkingLotEntity convert(ParkingLot parkingLot) {
            return ParkingLotEntity.builder()
                    .id(parkingLot.getId())
                    .name(parkingLot.getName())
                    .slotCount(parkingLot.getSlotCount())
                    .emptySlots(parkingLot.getEmptySlots())
                    .build();
    }
}
