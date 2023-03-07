package com.meawallet.parkingapp.repository.converter;


import com.meawallet.parkingapp.repository.entity.ParkingSlotEntity;
import com.meawallet.parkingapp.domain.ParkingSlot;
import org.springframework.stereotype.Component;

@Component
public class ParkingSlotDomainToParkingSlotEntity {
    public ParkingSlotEntity convert(ParkingSlot slot) {
        return ParkingSlotEntity.builder()
                .id(slot.getId())
                .slotNumber(slot.getSlotNumber())
                .isEmpty(slot.isEmpty())
                .parkingLotId(slot.getParkingLotId())
                .carId(slot.getCarId())
                .build();
    }
}
