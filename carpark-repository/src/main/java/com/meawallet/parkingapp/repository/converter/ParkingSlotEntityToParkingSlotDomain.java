package com.meawallet.parkingapp.repository.converter;

import com.meawallet.parkingapp.repository.entity.CarEntity;
import com.meawallet.parkingapp.repository.entity.ParkingSlotEntity;
import com.meawallet.parkingapp.domain.ParkingSlot;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ParkingSlotEntityToParkingSlotDomain {
    private final CarEntityToCarDomainConverter carEntityToCarDomainConverter;
    public ParkingSlot convert(ParkingSlotEntity entity) {
        return ParkingSlot.builder()
                .id(entity.getId())
                .slotNumber(entity.getSlotNumber())
                .isEmpty(entity.isEmpty())
                .car(entity.getCarEntity() != null ? carEntityToCarDomainConverter.convert(entity.getCarEntity()):null)
                .build();
    }
}
