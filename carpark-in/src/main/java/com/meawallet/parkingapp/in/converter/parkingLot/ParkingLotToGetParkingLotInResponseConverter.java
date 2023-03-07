package com.meawallet.parkingapp.in.converter.parkingLot;

import com.meawallet.parkingapp.domain.ParkingLot;
import com.meawallet.parkingapp.in.dto.parkingLot.GetParkingLotInResponse;
import org.springframework.stereotype.Component;

@Component
public class ParkingLotToGetParkingLotInResponseConverter {
    public GetParkingLotInResponse convert(ParkingLot parkingLot) {
        return new GetParkingLotInResponse(
                parkingLot.getId(),
                parkingLot.getName(),
                parkingLot.getSlotCount(),
                parkingLot.getEmptySlots()
        );
    }
}
