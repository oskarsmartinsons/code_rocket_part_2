package com.meawallet.parkingapp.core;

import com.meawallet.parkingapp.core.port.in.UpdateParkingLotUseCase;
import com.meawallet.parkingapp.core.port.out.FindParkingLotByIdPort;
import com.meawallet.parkingapp.core.port.out.UpdateParkingLotPort;
import com.meawallet.parkingapp.domain.ParkingLot;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UpdateParkingLotService implements UpdateParkingLotUseCase {
    private final FindParkingLotByIdPort findParkingLotByIdPort;
    private final UpdateParkingLotPort updateParkingLotPort;

    @Override
    public ParkingLot updateParkingLot(Integer id, ParkingLot parkingLot) {

        var updatedParkingLot = findParkingLotByIdPort.findById(id)
                .map(existingParkingLot -> ParkingLot.builder()
                        .id(existingParkingLot.getId())
                        .name(parkingLot.getName())
                        .slotCount(parkingLot.getSlotCount())
                        .emptySlots(parkingLot.getEmptySlots())
                        .build())
                .orElseThrow(()->new IllegalArgumentException("Parking Lot not found"));

        return updateParkingLotPort.update(updatedParkingLot);
    }
}
