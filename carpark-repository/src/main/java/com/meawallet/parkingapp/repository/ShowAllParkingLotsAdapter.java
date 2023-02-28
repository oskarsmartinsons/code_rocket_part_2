package com.meawallet.parkingapp.repository;

import com.meawallet.parkingapp.core.port.out.ShowParkingLotsPort;
import com.meawallet.parkingapp.domain.ParkingLot;
import com.meawallet.parkingapp.repository.repository.ParkingLotRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ShowAllParkingLotsAdapter implements ShowParkingLotsPort {
    private final ParkingLotRepository parkingLotRepository;
    @Override
    public List<ParkingLot> getAll() {
        return parkingLotRepository.getAllParkingLots();
    }
}
