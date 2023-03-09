package com.meawallet.parkingapp.in.converter.parkingSlot;

import com.meawallet.parkingapp.domain.ParkingSlot;
import com.meawallet.parkingapp.in.dto.parkingSlot.UpdateParkingSlotInRequest;
import org.springframework.stereotype.Component;

@Component
public class UpdateParkingSlotInRequestToDomainConverter {
    public ParkingSlot convert(UpdateParkingSlotInRequest request, Integer id) {
        return ParkingSlot.builder()
                .id(id)
                .slotNumber(request.slotNumber())
                .isEmpty(request.isEmpty())
                .build();
    }
}
