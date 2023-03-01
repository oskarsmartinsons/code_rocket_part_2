package com.meawallet.parkingapp.in.converter;

import com.meawallet.parkingapp.domain.ParkingLot;
import com.meawallet.parkingapp.in.dto.CreateParkingLotInResponse;
import org.springframework.stereotype.Component;

@Component
public class ParkingLotToCreateUserInResponseConverter {
    public CreateParkingLotInResponse convert(ParkingLot parkingLot) {
        return new CreateParkingLotInResponse(
                parkingLot.getId(),
                parkingLot.getName(),
                parkingLot.getSlotCount(),
                parkingLot.getEmptySlots()
        );
    }
}
