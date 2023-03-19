package com.meawallet.parkingapp.in.converter.parkingLot;

import com.meawallet.parkingapp.domain.Guard;
import com.meawallet.parkingapp.domain.ParkingLot;
import com.meawallet.parkingapp.in.converter.guard.GuardToGetGuardInResponseConverter;
import com.meawallet.parkingapp.in.converter.parkingSlot.ParkingSlotToGetParkingSlotInResponseConverter;
import com.meawallet.parkingapp.in.dto.parkingLot.GetParkingLotInResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ParkingLotToGetParkingLotInResponseConverter {
    private final ParkingSlotToGetParkingSlotInResponseConverter parkingSlotToGetParkingSlotInResponseConverter;
    private final GuardToGetGuardInResponseConverter guardToGetGuardInResponseConverter;
    public GetParkingLotInResponse convert(ParkingLot parkingLot) {

        var guardInResponse = Optional.ofNullable(parkingLot.getGuard())
                .map(guardToGetGuardInResponseConverter::convert)
                .orElse(null);

        return new GetParkingLotInResponse(
                parkingLot.getId(),
                parkingLot.getName(),
                parkingLot.getSlotCount(),
                parkingLot.getEmptySlots(),
                parkingLot.getParkingSlots().stream()
                        .map(parkingSlotToGetParkingSlotInResponseConverter::convert)
                        .collect(Collectors.toList()),
                guardInResponse
        );
    }
}
