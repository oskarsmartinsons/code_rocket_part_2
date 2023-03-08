package com.meawallet.parkingapp.core.parkingLotServices;

import com.meawallet.parkingapp.core.port.in.parkingLotUseCases.GetParkingSlotsForParkingLotUseCase;
import com.meawallet.parkingapp.core.port.out.parkingLotPorts.GetParkingSlotsForParkingLotPort;
import com.meawallet.parkingapp.domain.ParkingSlot;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class GetParkingSlotsForParkingLotService implements GetParkingSlotsForParkingLotUseCase {
    private final GetParkingSlotsForParkingLotPort getParkingSlotsForParkingLotPort;

    @Override
    public List<ParkingSlot> findParkingSlotsByParkingLotId(Integer parkingLotId) {
        return getParkingSlotsForParkingLotPort.findParkingSlotsByParkingLotId(parkingLotId);
    }
}
