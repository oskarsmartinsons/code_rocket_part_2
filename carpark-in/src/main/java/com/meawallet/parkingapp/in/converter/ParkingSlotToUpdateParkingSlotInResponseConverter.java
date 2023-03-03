package com.meawallet.parkingapp.in.converter;

import com.meawallet.parkingapp.domain.ParkingSlot;
import com.meawallet.parkingapp.in.dto.UpdateParkingSlotInResponse;
import org.springframework.stereotype.Component;

@Component
public class ParkingSlotToUpdateParkingSlotInResponseConverter {
    public UpdateParkingSlotInResponse convert(ParkingSlot parkingSlot) {
        return new UpdateParkingSlotInResponse(
                parkingSlot.getId(),
                parkingSlot.getSlotNumber(),
                parkingSlot.isEmpty(),
                parkingSlot.getParkingLotId(),
                parkingSlot.getCarId()
        );
    }
}
