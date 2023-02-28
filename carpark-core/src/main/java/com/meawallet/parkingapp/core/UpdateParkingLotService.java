package com.meawallet.parkingapp.core;

import com.meawallet.parkingapp.core.port.in.UpdateParkingLotUseCase;
import com.meawallet.parkingapp.core.port.out.UpdateParkingLotPort;
import com.meawallet.parkingapp.domain.ParkingLot;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UpdateParkingLotService implements UpdateParkingLotUseCase {
    private final UpdateParkingLotPort updateParkingLotPort;
    @Override
    public void update(ParkingLot updatedParkingLot) {
        if(updatedParkingLot==null) {throw new IllegalArgumentException("ParkingLot arg is invalid");}
        updateParkingLotPort.update(updatedParkingLot);
    }
}
