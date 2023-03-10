package com.meawallet.parkingapp.in.converter.parkingLot;

import com.meawallet.parkingapp.domain.ParkingLot;
import com.meawallet.parkingapp.in.converter.parkingSlot.ParkingSlotToUpdateParkingSlotInResponseConverter;
import com.meawallet.parkingapp.in.dto.parkingLot.UpdateParkingLotInResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ParkingLotToUpdateParkingLotInResponseConverter {
    private final ParkingSlotToUpdateParkingSlotInResponseConverter parkingSlotToUpdateParkingSlotInResponseConverter;
    public UpdateParkingLotInResponse convert(ParkingLot parkingLot) {
        return new UpdateParkingLotInResponse (
                parkingLot.getId(),
                parkingLot.getName(),
                parkingLot.getSlotCount(),
                parkingLot.getEmptySlots(),
                parkingLot.getParkingSlots().stream()
                        .map(parkingSlotToUpdateParkingSlotInResponseConverter::convert)
                        .collect(Collectors.toList())
        );
    }
}
