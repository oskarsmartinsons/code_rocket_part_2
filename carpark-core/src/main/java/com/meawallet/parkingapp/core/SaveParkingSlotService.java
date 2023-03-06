/*
package com.meawallet.parkingapp.core;

import com.meawallet.parkingapp.core.port.in.SaveParkingSlotUseCase;
import com.meawallet.parkingapp.core.port.out.SaveParkingSlotPort;
import com.meawallet.parkingapp.domain.ParkingSlot;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SaveParkingSlotService implements SaveParkingSlotUseCase {
    private final SaveParkingSlotPort saveParkingSlotPort;

    @Override
    public ParkingSlot saveParkingSlot(ParkingSlot parkingSlot) {
        if(parkingSlot==null) {throw new IllegalArgumentException("ParkingSlot arg is invalid");}
        return saveParkingSlotPort.save(parkingSlot);
    }
}
*/
