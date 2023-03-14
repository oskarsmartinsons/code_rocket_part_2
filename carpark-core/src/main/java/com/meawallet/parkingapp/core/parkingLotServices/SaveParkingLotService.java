package com.meawallet.parkingapp.core.parkingLotServices;

import com.meawallet.parkingapp.core.port.in.parkingLotUseCases.SaveParkingLotUseCase;
import com.meawallet.parkingapp.core.port.out.parkingLotPorts.SaveParkingLotPort;
import com.meawallet.parkingapp.domain.ParkingLot;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SaveParkingLotService implements SaveParkingLotUseCase {
    private final SaveParkingLotPort saveParkingLotPort;
    @Override
    public ParkingLot saveParkingLot(ParkingLot parkingLot) {
        if(parkingLot==null) {throw new IllegalArgumentException("ParkingLot arg is invalid");}
        return saveParkingLotPort.save(parkingLot);
    }
}
