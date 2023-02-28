package com.meawallet.parkingapp.core;

import com.meawallet.parkingapp.core.port.in.DeleteParkingLotUseCase;
import com.meawallet.parkingapp.core.port.out.DeleteParkingLotPort;
import com.meawallet.parkingapp.domain.ParkingLot;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeleteParkingLotService implements DeleteParkingLotUseCase{
    private final DeleteParkingLotPort deleteParkingLotPort;

    @Override
    public void deleteParkingLot(ParkingLot parkingLot) {
        deleteParkingLotPort.delete(parkingLot);
    }
}
