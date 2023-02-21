package com.meawallet.parkingapp.database.converter;


import com.meawallet.parkingapp.database.ParkingSlotEntity;
import com.meawallet.parkingapp.domain.ParkingSlot;
import org.springframework.stereotype.Component;

@Component
public class ParkingSlotDomainToParkingSlotEntity {
    public ParkingSlotEntity convert(ParkingSlot slot, Integer id) {
        return ParkingSlotEntity.builder()
                .id(id)
                .isEmpty(slot.isEmpty())
                .parkingLotId(slot.getParkingLotId())
                .carId(slot.getCarId())
                .build();
    }
}
