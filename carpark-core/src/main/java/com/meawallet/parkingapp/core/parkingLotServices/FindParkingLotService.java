package com.meawallet.parkingapp.core.parkingLotServices;

import com.meawallet.parkingapp.core.port.in.parkingLotUseCases.FindParkingLotUseCase;
import com.meawallet.parkingapp.core.port.out.parkingLotPorts.FindParkingLotByIdPort;
import com.meawallet.parkingapp.domain.ParkingLot;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FindParkingLotService implements FindParkingLotUseCase {
    private final FindParkingLotByIdPort findParkingLotByIdPort;

    @Override
    public ParkingLot findParkingLotById(Integer id) {
        return findParkingLotByIdPort.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Parking Lot not Found"));
    }
}

