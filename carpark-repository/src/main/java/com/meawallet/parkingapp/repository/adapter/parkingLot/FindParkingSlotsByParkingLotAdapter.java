package com.meawallet.parkingapp.repository.adapter.parkingLot;

import com.meawallet.parkingapp.core.port.out.parkingLotPorts.FindParkingSlotsByParkingLotPort;
import com.meawallet.parkingapp.domain.ParkingSlot;
import com.meawallet.parkingapp.repository.repository.ParkingLotRepository;
import com.meawallet.parkingapp.repository.repository.ParkingSlotRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class FindParkingSlotsByParkingLotAdapter implements FindParkingSlotsByParkingLotPort {
    private final ParkingSlotRepository parkingSlotRepository;
    private final ParkingLotRepository parkingLotRepository;

    @Override
    public List<ParkingSlot> findParkingSlotsByParkingLotId(Integer parkingLotId) {
       // return parkingSlotRepository.findByParkingLotId(parkingLotId);
        return parkingSlotRepository.findAllById(parkingLotId);
    }
}
