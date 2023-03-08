package com.meawallet.parkingapp.repository.adapter.parkingLot;

import com.meawallet.parkingapp.core.port.out.parkingLotPorts.GetParkingSlotsForParkingLotPort;
import com.meawallet.parkingapp.domain.ParkingLot;
import com.meawallet.parkingapp.domain.ParkingSlot;
import com.meawallet.parkingapp.repository.repository.ParkingLotRepository;
import com.meawallet.parkingapp.repository.repository.ParkingSlotRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class GetParkingSlotsForParkingLotAdapter implements GetParkingSlotsForParkingLotPort {
    private final ParkingSlotRepository parkingSlotRepository;

    @Override
    public List<ParkingSlot> findParkingSlotsByParkingLotId(Integer parkingLotId) {
        return null; //parkingSlotRepository.findByParkingLotId(parkingLotId);
    }
}
