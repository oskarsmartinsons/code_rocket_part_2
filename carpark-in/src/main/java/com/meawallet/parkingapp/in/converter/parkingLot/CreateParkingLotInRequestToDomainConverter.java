package com.meawallet.parkingapp.in.converter.parkingLot;

import com.meawallet.parkingapp.domain.ParkingLot;
import com.meawallet.parkingapp.in.converter.parkingSlot.CreateParkingSlotInRequestToDomainConverter;
import com.meawallet.parkingapp.in.dto.parkingLot.CreateParkingLotInRequest;
import com.meawallet.parkingapp.in.dto.parkingSlot.CreateParkingSlotInRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CreateParkingLotInRequestToDomainConverter {
    private final CreateParkingSlotInRequestToDomainConverter createParkingSlotInRequestToDomainConverter;

    public ParkingLot convert(CreateParkingLotInRequest request) {

        List<CreateParkingSlotInRequest> createSlotsInRequests = request.createParkingSlotsInRequests()
                .orElse(Collections.emptyList());

        return ParkingLot.builder()
                .name(request.name())
                .slotCount(request.slotCount())
                .emptySlots(request.emptySlots())
                .parkingSlots(createSlotsInRequests.stream()
                        .map(createParkingSlotInRequestToDomainConverter::convert)
                        .collect(Collectors.toList()))
                .build();
    }
}
