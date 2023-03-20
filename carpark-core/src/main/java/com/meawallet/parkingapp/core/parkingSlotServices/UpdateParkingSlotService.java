package com.meawallet.parkingapp.core.parkingSlotServices;

import com.meawallet.parkingapp.exception.EntityNotFoundException;
import com.meawallet.parkingapp.core.port.in.parkingSlotUseCases.UpdateParkingSlotUseCase;
import com.meawallet.parkingapp.core.port.out.parkingSlotPorts.FindParkingSlotByIdPort;
import com.meawallet.parkingapp.core.port.out.parkingSlotPorts.UpdateParkingSlotPort;
import com.meawallet.parkingapp.domain.ParkingSlot;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
@Slf4j
@Component
@AllArgsConstructor
public class UpdateParkingSlotService implements UpdateParkingSlotUseCase {
    private final UpdateParkingSlotPort updateParkingSlotPort;
    private final FindParkingSlotByIdPort findParkingSlotByIdPort;
    @Override
    public void updateParkingSlot(ParkingSlot parkingSlot) {
        findParkingSlotByIdPort.findById(parkingSlot.getId())
                .orElseThrow(()->new EntityNotFoundException("Parking Slot with id " + parkingSlot.getId() + " not found for update"));

        log.debug("PARKING SLOT found by id: {}", parkingSlot.getId());
        updateParkingSlotPort.update(parkingSlot);
    }
}
