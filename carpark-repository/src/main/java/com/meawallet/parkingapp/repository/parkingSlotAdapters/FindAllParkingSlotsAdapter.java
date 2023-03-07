package com.meawallet.parkingapp.repository.parkingSlotAdapters;

import com.meawallet.parkingapp.core.port.out.parkingSlotPorts.FindAllParkingSlotPort;
import com.meawallet.parkingapp.domain.ParkingSlot;
import com.meawallet.parkingapp.repository.converter.ParkingSlotEntityToParkingSlotDomain;
import com.meawallet.parkingapp.repository.repository.ParkingSlotRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class FindAllParkingSlotsAdapter implements FindAllParkingSlotPort {
    private final ParkingSlotRepository parkingSlotRepository;
    private final ParkingSlotEntityToParkingSlotDomain parkingSlotEntityToParkingSlotDomain;
    @Override
    public List<ParkingSlot> getAll() {
        return parkingSlotRepository.findAll().stream()
                .map(parkingSlotEntityToParkingSlotDomain::convert)
                .collect(Collectors.toList());
    }
}
