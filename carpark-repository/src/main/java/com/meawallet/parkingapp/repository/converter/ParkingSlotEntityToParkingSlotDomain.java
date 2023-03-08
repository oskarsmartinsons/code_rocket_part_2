package com.meawallet.parkingapp.repository.converter;

import com.meawallet.parkingapp.repository.entity.ParkingSlotEntity;
import com.meawallet.parkingapp.domain.ParkingSlot;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ParkingSlotEntityToParkingSlotDomain {
   // private final ParkingLotEntityToParkingLotDomain parkingLotEntityToParkingLotDomain;
    public ParkingSlot convert(ParkingSlotEntity entity) {
        return ParkingSlot.builder()
                .id(entity.getId())
                .slotNumber(entity.getSlotNumber())
                .isEmpty(entity.isEmpty())
            //    .parkingLot(parkingLotEntityToParkingLotDomain.convert(entity.getParkingLotEntity()))
            //    .carId(entity.getCarId())
                .build();
    }
}
