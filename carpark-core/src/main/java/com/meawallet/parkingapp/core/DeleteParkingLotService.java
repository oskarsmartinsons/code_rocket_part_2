/*
package com.meawallet.parkingapp.core;

import com.meawallet.parkingapp.core.port.in.DeleteParkingLotUseCase;
import com.meawallet.parkingapp.core.port.out.DeleteParkingLotPort;
import com.meawallet.parkingapp.core.port.out.FindParkingLotByIdPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeleteParkingLotService implements DeleteParkingLotUseCase{
    private final FindParkingLotByIdPort findParkingLotByIdPort;
    private final DeleteParkingLotPort deleteParkingLotPort;

    @Override
    public void deleteParkingLotById(Integer id) {
        var parkingLotToDelete = findParkingLotByIdPort.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Parking Lot not found"));
        deleteParkingLotPort.delete(parkingLotToDelete);
    }
}
*/
