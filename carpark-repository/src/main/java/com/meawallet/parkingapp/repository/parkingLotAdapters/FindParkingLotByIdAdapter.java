package com.meawallet.parkingapp.repository.parkingLotAdapters;

import com.meawallet.parkingapp.core.port.out.parkingLotPorts.FindParkingLotByIdPort;
import com.meawallet.parkingapp.domain.ParkingLot;
import com.meawallet.parkingapp.repository.converter.ParkingLotEntityToParkingLotDomain;
import com.meawallet.parkingapp.repository.repository.ParkingLotRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
@AllArgsConstructor
public class FindParkingLotByIdAdapter implements FindParkingLotByIdPort {
    private final ParkingLotRepository parkingLotRepository;
    private final ParkingLotEntityToParkingLotDomain parkingLotEntityToParkingLotDomain;
    @Override
    public Optional<ParkingLot> findById(Integer id) {
        return parkingLotRepository.findById(id)
                .map(parkingLotEntityToParkingLotDomain::convert);
    }
}
