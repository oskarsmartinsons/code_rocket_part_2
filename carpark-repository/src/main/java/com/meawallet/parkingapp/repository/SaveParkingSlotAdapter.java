package com.meawallet.parkingapp.repository;

import com.meawallet.parkingapp.core.port.out.SaveParkingSlotPort;
import com.meawallet.parkingapp.domain.ParkingSlot;
import com.meawallet.parkingapp.repository.repository.ParkingSlotRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Transactional
@AllArgsConstructor
public class SaveParkingSlotAdapter implements SaveParkingSlotPort {
    private final ParkingSlotRepository parkingSlotRepository;

    @Override
    public ParkingSlot save(ParkingSlot parkingSlot) {
        return parkingSlotRepository.save(parkingSlot);
    }
}
