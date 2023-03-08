package com.meawallet.parkingapp.repository.converter;


import com.meawallet.parkingapp.repository.entity.ParkingLotEntity;
import com.meawallet.parkingapp.repository.entity.ParkingSlotEntity;
import com.meawallet.parkingapp.domain.ParkingSlot;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ParkingSlotDomainToParkingSlotEntity {
   // private final ParkingLotDomainToParkingLotEntity parkingLotDomainToParkingLotEntity;
    public ParkingSlotEntity convert(ParkingSlot slot) {
        return ParkingSlotEntity.builder()
                .id(slot.getId())
                .slotNumber(slot.getSlotNumber())
                .isEmpty(slot.isEmpty())
             //   .parkingLotEntity(parkingLotDomainToParkingLotEntity.convert(slot.getParkingLot()))
             //   .carId(slot.getCarId())
                .build();
    }
}
