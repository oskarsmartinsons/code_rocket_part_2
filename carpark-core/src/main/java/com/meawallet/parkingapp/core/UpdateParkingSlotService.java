/*
package com.meawallet.parkingapp.core;

import com.meawallet.parkingapp.core.port.in.UpdateParkingSlotUseCase;
import com.meawallet.parkingapp.core.port.out.FindParkingSlotByIdPort;
import com.meawallet.parkingapp.core.port.out.UpdateParkingSlotPort;
import com.meawallet.parkingapp.domain.ParkingSlot;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UpdateParkingSlotService implements UpdateParkingSlotUseCase {
    private final FindParkingSlotByIdPort findParkingSlotByIdPort;
    private final UpdateParkingSlotPort updateParkingSlotPort;
    @Override
    public ParkingSlot updateParkingSlot(Integer id, ParkingSlot parkingSlot) {
        var updatedParkingSlot = findParkingSlotByIdPort.findById(id)
                .map(existingParkingSlot -> ParkingSlot.builder()
                        .id(existingParkingSlot.getId())
                        .slotNumber(parkingSlot.getSlotNumber())
                        .isEmpty(parkingSlot.isEmpty())
                        .parkingLotId(parkingSlot.getParkingLotId())
                        .carId(parkingSlot.getCarId())
                        .build())
                .orElseThrow(()->new IllegalArgumentException("Parking Slot not found"));

        return updateParkingSlotPort.update(updatedParkingSlot);
    }
}
*/
