package com.meawallet.parkingapp.core.parkingLotServices;

import com.meawallet.parkingapp.core.port.in.parkingLotUseCases.UpdateParkingLotUseCase;
import com.meawallet.parkingapp.core.port.out.parkingLotPorts.FindParkingLotByIdPort;
import com.meawallet.parkingapp.core.port.out.parkingLotPorts.UpdateParkingLotPort;
import com.meawallet.parkingapp.domain.ParkingLot;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
@Slf4j
@Component
@AllArgsConstructor
public class UpdateParkingLotService implements UpdateParkingLotUseCase {
    private final FindParkingLotByIdPort findParkingLotByIdPort;
    private final UpdateParkingLotPort updateParkingLotPort;

    @Override
    public ParkingLot updateParkingLot(ParkingLot parkingLot) {
        findParkingLotByIdPort.findById(parkingLot.getId())
                .orElseThrow(()->new IllegalArgumentException("Parking Lot not found"));
        log.debug("PARKING LOT found by id: {}", parkingLot.getId());
        return updateParkingLotPort.update(parkingLot);

    }
}
