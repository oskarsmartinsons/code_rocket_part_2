package com.meawallet.parkingapp.in.converter.parkingLot;

import com.meawallet.parkingapp.domain.ParkingLot;
import com.meawallet.parkingapp.in.converter.parkingSlot.ParkingSlotToCreateParkingSlotInResponseConverter;
import com.meawallet.parkingapp.in.dto.parkingLot.CreateParkingLotInResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ParkingLotToCreateParkingLotInResponseConverter {
    private final ParkingSlotToCreateParkingSlotInResponseConverter parkingSlotToCreateParkingSlotInResponseConverter;

    public CreateParkingLotInResponse convert(ParkingLot parkingLot) {
        return new CreateParkingLotInResponse(
                parkingLot.getId(),
                parkingLot.getName(),
                parkingLot.getSlotCount(),
                parkingLot.getEmptySlots(),
                parkingLot.getParkingSlots().stream()
                        .map(parkingSlotToCreateParkingSlotInResponseConverter::convert)
                        .collect(Collectors.toList())
        );
    }
}
