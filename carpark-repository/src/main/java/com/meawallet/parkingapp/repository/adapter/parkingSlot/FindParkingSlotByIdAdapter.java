package com.meawallet.parkingapp.repository.adapter.parkingSlot;

import com.meawallet.parkingapp.core.port.out.parkingSlotPorts.FindParkingSlotByIdPort;
import com.meawallet.parkingapp.domain.ParkingSlot;
import com.meawallet.parkingapp.repository.converter.ParkingSlotEntityToParkingSlotDomain;
import com.meawallet.parkingapp.repository.repository.ParkingSlotRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class FindParkingSlotByIdAdapter implements FindParkingSlotByIdPort {
    private final ParkingSlotRepository parkingSlotRepository;
    private final ParkingSlotEntityToParkingSlotDomain parkingSlotEntityToParkingSlotDomain;

    @Override
    public Optional<ParkingSlot> findById(Integer id) {
        return parkingSlotRepository.findById(id)
                .map(parkingSlotEntityToParkingSlotDomain::convert);
    }
}
