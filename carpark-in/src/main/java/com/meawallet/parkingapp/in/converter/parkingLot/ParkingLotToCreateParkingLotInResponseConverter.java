package com.meawallet.parkingapp.in.converter.parkingLot;

import com.meawallet.parkingapp.domain.ParkingLot;
import com.meawallet.parkingapp.in.dto.parkingLot.CreateParkingLotInResponse;
import org.springframework.stereotype.Component;

@Component
public class ParkingLotToCreateParkingLotInResponseConverter {
    public CreateParkingLotInResponse convert(ParkingLot parkingLot) {
        return new CreateParkingLotInResponse(
                parkingLot.getId(),
                parkingLot.getName(),
                parkingLot.getSlotCount(),
                parkingLot.getEmptySlots(),
                parkingLot.getParkingSlots()
        );
    }
}
