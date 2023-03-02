package com.meawallet.parkingapp.in.converter;

import com.meawallet.parkingapp.domain.ParkingLot;
import com.meawallet.parkingapp.in.dto.UpdateParkingLotInResponse;
import org.springframework.stereotype.Component;

@Component
public class ParkingLotToUpdateParkingLotInResponseConverter {
    public UpdateParkingLotInResponse convert(ParkingLot parkingLot) {
        return new UpdateParkingLotInResponse (
                parkingLot.getId(),
                parkingLot.getName(),
                parkingLot.getSlotCount(),
                parkingLot.getEmptySlots()
        );
    }
}
