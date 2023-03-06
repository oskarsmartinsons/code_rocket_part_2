/*
package com.meawallet.parkingapp.core;

import com.meawallet.parkingapp.core.port.in.DeleteParkingSlotUseCase;
import com.meawallet.parkingapp.core.port.out.DeleteParkingSlotPort;
import com.meawallet.parkingapp.core.port.out.FindParkingSlotByIdPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeleteParkingSlotService implements DeleteParkingSlotUseCase {
    private final FindParkingSlotByIdPort findParkingSlotByIdPort;
    private final DeleteParkingSlotPort deleteParkingSlotPort;

    @Override
    public void deleteParkingSlotById(Integer id) {
        var parkingSlotToDelete = findParkingSlotByIdPort.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Parking Slot not found"));
        deleteParkingSlotPort.delete(parkingSlotToDelete);
    }
}
*/
