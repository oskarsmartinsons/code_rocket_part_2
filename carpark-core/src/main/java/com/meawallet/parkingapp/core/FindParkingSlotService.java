package com.meawallet.parkingapp.core;

import com.meawallet.parkingapp.core.port.in.FindParkingSlotUseCase;
import com.meawallet.parkingapp.core.port.out.FindParkingSlotByIdPort;
import com.meawallet.parkingapp.domain.ParkingSlot;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FindParkingSlotService implements FindParkingSlotUseCase {
    private final FindParkingSlotByIdPort findParkingSlotByIdPort;
    @Override
    public ParkingSlot findParkingSlotById(Integer id) {
        if(id==null) {throw new IllegalArgumentException("Id arg is invalid");}
        return findParkingSlotByIdPort.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Parking Slot not found"));
    }
}
