package com.meawallet.parkingapp.core.parkingLotServices;

import com.meawallet.parkingapp.core.port.in.parkingLotUseCases.DeleteParkingLotUseCase;
import com.meawallet.parkingapp.core.port.out.parkingLotPorts.DeleteParkingLotPort;
import com.meawallet.parkingapp.core.port.out.parkingLotPorts.FindParkingLotByIdPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeleteParkingLotService implements DeleteParkingLotUseCase{
    private final FindParkingLotByIdPort findParkingLotByIdPort;
    private final DeleteParkingLotPort deleteParkingLotPort;

    @Override
    public void deleteParkingLotById(Integer id) {
        findParkingLotByIdPort.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Parking Lot not found"));
        deleteParkingLotPort.deleteById(id);
    }
}
