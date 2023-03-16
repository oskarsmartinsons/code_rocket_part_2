package com.meawallet.parkingapp.core.parkingSlotServices;

import com.meawallet.parkingapp.core.exception.EntityNotFoundException;
import com.meawallet.parkingapp.core.port.in.parkingSlotUseCases.FindParkingSlotUseCase;
import com.meawallet.parkingapp.core.port.out.parkingSlotPorts.FindParkingSlotByIdPort;
import com.meawallet.parkingapp.domain.ParkingSlot;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FindParkingSlotService implements FindParkingSlotUseCase {
    private final FindParkingSlotByIdPort findParkingSlotByIdPort;
    @Override
    public ParkingSlot findParkingSlotById(Integer id) throws EntityNotFoundException {
        if(id==null) {throw new IllegalArgumentException("Id arg is invalid");}
        return findParkingSlotByIdPort.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Parking Slot not found with id: " + id));
    }
}
