package com.meawallet.parkingapp.repository.parkingLotAdapters;

import com.meawallet.parkingapp.core.port.out.parkingLotPorts.FindAllParkingLotsPort;
import com.meawallet.parkingapp.domain.ParkingLot;
import com.meawallet.parkingapp.repository.converter.ParkingLotEntityToParkingLotDomain;
import com.meawallet.parkingapp.repository.repository.ParkingLotRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class FindAllParkingLotsAdapter implements FindAllParkingLotsPort {
    private final ParkingLotRepository parkingLotRepository;
    private final ParkingLotEntityToParkingLotDomain parkingLotEntityToParkingLotDomain;
    @Override
    public List<ParkingLot> getAll() {
        return parkingLotRepository.findAll().stream()
                .map(parkingLotEntityToParkingLotDomain::convert)
                .collect(Collectors.toList());
    }
}
