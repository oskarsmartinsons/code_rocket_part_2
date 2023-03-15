package com.meawallet.parkingapp.repository.converter;

import com.meawallet.parkingapp.domain.ParkingLot;
import com.meawallet.parkingapp.repository.entity.ParkingLotEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ParkingLotDomainToParkingLotEntity {
    private final GuardToGuardEntityConverter guardToGuardEntityConverter;
    private final ParkingSlotDomainToParkingSlotEntity parkingSlotDomainToParkingSlotEntity;
    public ParkingLotEntity convert(ParkingLot parkingLot) {

        var guardEntity = guardToGuardEntityConverter.convert(parkingLot.getGuard());
            return ParkingLotEntity.builder()
                    .id(parkingLot.getId())
                    .name(parkingLot.getName())
                    .slotCount(parkingLot.getSlotCount())
                    .emptySlots(parkingLot.getEmptySlots())
                    .parkingSlotEntities(parkingLot.getParkingSlots()
                            .stream()
                            .map(parkingSlotDomainToParkingSlotEntity::convert)
                            .collect(Collectors.toList()))
                    .guardEntity(guardEntity)
                    .build();
    }
}
