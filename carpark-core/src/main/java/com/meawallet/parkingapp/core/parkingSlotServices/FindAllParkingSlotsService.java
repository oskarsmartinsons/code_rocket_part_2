package com.meawallet.parkingapp.core.parkingSlotServices;

import com.meawallet.parkingapp.core.port.in.parkingSlotUseCases.FindAllParkingSlotsUseCase;
import com.meawallet.parkingapp.core.port.out.parkingSlotPorts.FindAllParkingSlotPort;
import com.meawallet.parkingapp.domain.ParkingSlot;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class FindAllParkingSlotsService implements FindAllParkingSlotsUseCase {
    private final FindAllParkingSlotPort findAllParkingSlotPort;

    @Override
    public List<ParkingSlot> findAllParkingSlots() {
        return findAllParkingSlotPort.getAll();
    }
}
