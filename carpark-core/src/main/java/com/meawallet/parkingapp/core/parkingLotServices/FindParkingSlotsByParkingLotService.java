package com.meawallet.parkingapp.core.parkingLotServices;

import com.meawallet.parkingapp.core.port.in.parkingLotUseCases.FindParkingSlotsByParkingLotUseCase;
import com.meawallet.parkingapp.core.port.out.parkingLotPorts.FindParkingSlotsByParkingLotPort;
import com.meawallet.parkingapp.domain.ParkingSlot;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class FindParkingSlotsByParkingLotService implements FindParkingSlotsByParkingLotUseCase {
    private final FindParkingSlotsByParkingLotPort findParkingSlotsByParkingLotPort;

    @Override
    public List<ParkingSlot> findParkingSlotsByParkingLotId(Integer parkingLotId) {
        return findParkingSlotsByParkingLotPort.findParkingSlotsByParkingLotId(parkingLotId);
    }
}
