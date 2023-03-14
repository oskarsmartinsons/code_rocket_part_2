package com.meawallet.parkingapp.core.carServices;

import com.meawallet.parkingapp.core.port.in.carUseCases.AddCarToParkingSlotUseCase;
import com.meawallet.parkingapp.core.port.out.carPorts.AddCarToSlotPort;
import com.meawallet.parkingapp.core.port.out.parkingLotPorts.SubtractEmptyParkingSlotPort;
import com.meawallet.parkingapp.domain.Car;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class AddCarToParkingSlotService implements AddCarToParkingSlotUseCase {
    private final AddCarToSlotPort addCarToSlotPort;
    private final SubtractEmptyParkingSlotPort subtractEmptyParkingSlotPort;

    @Override
    public void addCarInParkingSlot(Car car, Integer slotId) {
        if(car == null) {throw new IllegalArgumentException("Car arg is invalid");}

        addCarToSlotPort.addCarToParkingSlot(car, slotId);
        subtractEmptyParkingSlotPort.subtractEmptySlotForLot(slotId);
    }
}
