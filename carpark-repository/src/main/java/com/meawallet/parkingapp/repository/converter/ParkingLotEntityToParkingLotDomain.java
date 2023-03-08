package com.meawallet.parkingapp.repository.converter;

import com.meawallet.parkingapp.repository.entity.ParkingLotEntity;
import com.meawallet.parkingapp.domain.ParkingLot;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ParkingLotEntityToParkingLotDomain {
    private final ParkingSlotEntityToParkingSlotDomain parkingSlotEntityToParkingSlotDomain;
    public ParkingLot convert (ParkingLotEntity entity) {
        return ParkingLot.builder()
                .id(entity.getId())
                .name(entity.getName())
                .slotCount(entity.getSlotCount())
                .emptySlots(entity.getEmptySlots())
                .parkingSlots(entity.getParkingSlotEntities()
                                .stream()
                                .map(parkingSlotEntityToParkingSlotDomain::convert)
                                .collect(Collectors.toList())
                )
                .build();
    }
}
