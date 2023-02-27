package com.meawallet.parkingapp.database.converter;

import com.meawallet.parkingapp.database.ParkingLotEntity;
import com.meawallet.parkingapp.domain.ParkingLot;
import org.springframework.stereotype.Component;

@Component
public class ParkingLotDomainToParkingLotEntity {
    public ParkingLotEntity convert(ParkingLot parkingLot) {
            return ParkingLotEntity.builder()
                    //   .id(parkingLot.getId())
                .name(parkingLot.getName())
                .slotCount(parkingLot.getSlotCount())
                .emptySlots(parkingLot.getEmptySlots())
                .build();
    }
}
