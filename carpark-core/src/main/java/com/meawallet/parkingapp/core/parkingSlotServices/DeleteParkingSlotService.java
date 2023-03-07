package com.meawallet.parkingapp.core.parkingSlotServices;

import com.meawallet.parkingapp.core.port.in.parkingSlotUseCases.DeleteParkingSlotUseCase;
import com.meawallet.parkingapp.core.port.out.parkingSlotPorts.DeleteParkingSlotPort;
import com.meawallet.parkingapp.core.port.out.parkingSlotPorts.FindParkingSlotByIdPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeleteParkingSlotService implements DeleteParkingSlotUseCase {
   // private final FindParkingSlotByIdPort findParkingSlotByIdPort;
    private final DeleteParkingSlotPort deleteParkingSlotPort;

    @Override
    public void deleteParkingSlotById(Integer id) {
//        var parkingSlotToDelete = findParkingSlotByIdPort.findById(id)
//                .orElseThrow(()-> new IllegalArgumentException("Parking Slot not found"));
        deleteParkingSlotPort.deleteById(id);
    }
}
