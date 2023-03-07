package com.meawallet.parkingapp.in.converter.parkingSlot;

import com.meawallet.parkingapp.domain.ParkingSlot;
import com.meawallet.parkingapp.in.dto.parkingSlot.GetParkingSlotInResponse;
import org.springframework.stereotype.Component;

@Component
public class ParkingSlotToGetParkingSlotInResponseConverter {
    public GetParkingSlotInResponse convert(ParkingSlot parkingSlot){
        return new GetParkingSlotInResponse(
                parkingSlot.getId(),
                parkingSlot.getSlotNumber(),
                parkingSlot.isEmpty(),
                parkingSlot.getParkingLotId(),
                parkingSlot.getCarId()
        );
    }
}
