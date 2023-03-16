package com.meawallet.parkingapp.in.converter.parkingLot;

import com.meawallet.parkingapp.domain.ParkingLot;
import com.meawallet.parkingapp.in.converter.guard.GuardToCreateGuardInResponseConverter;
import com.meawallet.parkingapp.in.converter.parkingSlot.ParkingSlotToCreateParkingSlotInResponseConverter;
import com.meawallet.parkingapp.in.dto.parkingLot.CreateParkingLotInResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ParkingLotToCreateParkingLotInResponseConverter {
    private final ParkingSlotToCreateParkingSlotInResponseConverter parkingSlotToCreateParkingSlotInResponseConverter;
    private final GuardToCreateGuardInResponseConverter guardToCreateGuardInResponseConverter;
    public CreateParkingLotInResponse convert(ParkingLot parkingLot) {
        var guardInResponse = guardToCreateGuardInResponseConverter.convert(parkingLot.getGuard());

        return new CreateParkingLotInResponse(
                parkingLot.getId(),
                parkingLot.getName(),
                parkingLot.getSlotCount(),
                parkingLot.getEmptySlots(),
                parkingLot.getParkingSlots().stream()
                        .map(parkingSlotToCreateParkingSlotInResponseConverter::convert)
                        .collect(Collectors.toList()),
                guardInResponse
        );
    }
}
