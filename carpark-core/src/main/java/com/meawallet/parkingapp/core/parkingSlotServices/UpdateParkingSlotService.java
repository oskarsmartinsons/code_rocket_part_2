package com.meawallet.parkingapp.core.parkingSlotServices;

import com.meawallet.parkingapp.core.port.in.parkingSlotUseCases.UpdateParkingSlotUseCase;
import com.meawallet.parkingapp.core.port.out.parkingSlotPorts.FindParkingSlotByIdPort;
import com.meawallet.parkingapp.core.port.out.parkingSlotPorts.UpdateParkingSlotPort;
import com.meawallet.parkingapp.domain.ParkingSlot;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UpdateParkingSlotService implements UpdateParkingSlotUseCase {
    private final UpdateParkingSlotPort updateParkingSlotPort;
    private final FindParkingSlotByIdPort findParkingSlotByIdPort;
    @Override
    public void updateParkingSlot(ParkingSlot parkingSlot) {
        findParkingSlotByIdPort.findById(parkingSlot.getId())
                .orElseThrow(()->new IllegalArgumentException("Parking Slot not found"));

        updateParkingSlotPort.update(parkingSlot);
    }
}
