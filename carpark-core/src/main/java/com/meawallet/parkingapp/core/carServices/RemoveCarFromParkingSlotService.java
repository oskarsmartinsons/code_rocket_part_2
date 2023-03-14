package com.meawallet.parkingapp.core.carServices;

import com.meawallet.parkingapp.core.port.in.carUseCases.RemoveCarFromParkingSlotUseCase;
import com.meawallet.parkingapp.core.port.out.carPorts.RemoveCarFromSlotPort;
import com.meawallet.parkingapp.core.port.out.parkingLotPorts.AddEmptyParkingSlotPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RemoveCarFromParkingSlotService implements RemoveCarFromParkingSlotUseCase {
    private final RemoveCarFromSlotPort removeCarFromParkingSlotPort;
    private final AddEmptyParkingSlotPort addEmptyParkingSlotPort;

    @Override
    public void removeCarFromParkingSlot(Integer slotId) {
        removeCarFromParkingSlotPort.removeCarFromParkingSlot(slotId);
        addEmptyParkingSlotPort.addEmptySlotForLot(slotId);
    }
}
