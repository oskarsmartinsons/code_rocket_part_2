
package com.meawallet.parkingapp.core;

import com.meawallet.parkingapp.core.port.in.FindParkingLotUseCase;
import com.meawallet.parkingapp.core.port.out.FindParkingLotByIdPort;
import com.meawallet.parkingapp.domain.ParkingLot;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GetParkingLotService implements FindParkingLotUseCase {
    private final FindParkingLotByIdPort findParkingLotByIdPort;

    @Override
    public ParkingLot getParkingLot(Integer id) {
        return findParkingLotByIdPort.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Parking Lot not Found"));
    }
}

