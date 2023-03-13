package com.meawallet.parkingapp.in.converter.parkingSlot;

import com.meawallet.parkingapp.domain.ParkingSlot;
import com.meawallet.parkingapp.in.converter.car.UpdateCarInRequestToDomainConverter;
import com.meawallet.parkingapp.in.dto.parkingSlot.UpdateParkingSlotInRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UpdateParkingSlotInRequestToDomainConverter {
    private final UpdateCarInRequestToDomainConverter updateCarInRequestToDomainConverter;
    public ParkingSlot convert(UpdateParkingSlotInRequest request, Integer id) {
        return ParkingSlot.builder()
                .id(id)
                .slotNumber(request.slotNumber())
                .isEmpty(request.isEmpty())
                .build();
    }
}
