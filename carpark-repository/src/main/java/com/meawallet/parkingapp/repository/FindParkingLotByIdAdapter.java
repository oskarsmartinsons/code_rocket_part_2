package com.meawallet.parkingapp.repository;

import com.meawallet.parkingapp.core.port.out.FindParkingLotByIdPort;
import com.meawallet.parkingapp.domain.ParkingLot;
import com.meawallet.parkingapp.repository.repository.ParkingLotRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
@AllArgsConstructor
public class FindParkingLotByIdAdapter implements FindParkingLotByIdPort {
    private final ParkingLotRepository parkingLotRepository;
    @Override
    public Optional<ParkingLot> findById(Integer id) {
        return parkingLotRepository.getParkingLotById(id);
    }
}
