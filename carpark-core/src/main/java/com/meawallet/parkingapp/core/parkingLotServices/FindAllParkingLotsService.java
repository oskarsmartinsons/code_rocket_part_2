package com.meawallet.parkingapp.core.parkingLotServices;

import com.meawallet.parkingapp.core.port.in.parkingLotUseCases.FindAllParkingLotsUseCase;
import com.meawallet.parkingapp.core.port.out.parkingLotPorts.FindAllParkingLotsPort;
import com.meawallet.parkingapp.domain.ParkingLot;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class FindAllParkingLotsService implements FindAllParkingLotsUseCase {
    private final FindAllParkingLotsPort findAllParkingLotsPort;
    @Override
    public List<ParkingLot> findAllParkingLots() {
        return findAllParkingLotsPort.getAll();
    }
}
