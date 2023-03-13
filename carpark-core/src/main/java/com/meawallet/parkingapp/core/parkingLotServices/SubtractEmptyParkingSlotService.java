package com.meawallet.parkingapp.core.parkingLotServices;

import com.meawallet.parkingapp.core.port.in.parkingLotUseCases.SubtractEmptySlotUseCase;
import com.meawallet.parkingapp.core.port.out.parkingLotPorts.SubtractEmptyParkingSlotPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SubtractEmptyParkingSlotService implements SubtractEmptySlotUseCase {
    private final SubtractEmptyParkingSlotPort subtractEmptyParkingSlotPort;
    @Override
    public void subtractEmptySlot(Integer slotId) {
        subtractEmptyParkingSlotPort.subtractEmptySlot(slotId);
    }
}
