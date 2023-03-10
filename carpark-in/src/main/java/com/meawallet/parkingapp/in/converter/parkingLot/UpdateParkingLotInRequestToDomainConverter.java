package com.meawallet.parkingapp.in.converter.parkingLot;

import com.meawallet.parkingapp.domain.ParkingLot;
import com.meawallet.parkingapp.in.converter.parkingSlot.CreateParkingSlotInRequestToDomainConverter;
import com.meawallet.parkingapp.in.converter.parkingSlot.UpdateParkingSlotInRequestToDomainConverter;
import com.meawallet.parkingapp.in.dto.parkingLot.UpdateParkingLotInRequest;
import com.meawallet.parkingapp.in.dto.parkingSlot.UpdateParkingSlotInRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class UpdateParkingLotInRequestToDomainConverter {
    private final UpdateParkingSlotInRequestToDomainConverter updateParkingSlotInRequestToDomainConverter;

    public ParkingLot convert(UpdateParkingLotInRequest request, Integer id) {

        List<UpdateParkingSlotInRequest> updateParkingSlotsInRequest = request.updateParkingSlotsInRequests()
                .orElse(Collections.emptyList());

        return ParkingLot.builder()
                .id(id)
                .name(request.name())
                .slotCount(request.slotCount())
                .emptySlots(request.emptySlots())
                .parkingSlots(updateParkingSlotsInRequest.stream()
                        .map(slotUpdateRequest -> updateParkingSlotInRequestToDomainConverter.convert(slotUpdateRequest, slotUpdateRequest.id()))
                        .collect(Collectors.toList())
                )
                .build();
    }
}
