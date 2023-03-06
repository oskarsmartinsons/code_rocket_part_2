/*
package com.meawallet.parkingapp.repository;

import com.meawallet.parkingapp.core.port.out.FindParkingSlotByIdPort;
import com.meawallet.parkingapp.domain.ParkingSlot;
import com.meawallet.parkingapp.repository.repository.ParkingSlotRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class FindParkingSlotByIdAdapter implements FindParkingSlotByIdPort {
    private final ParkingSlotRepository parkingSlotRepository;

    @Override
    public Optional<ParkingSlot> findById(Integer id) {
        return parkingSlotRepository.getParkingSlotById(id);
    }
}
*/
