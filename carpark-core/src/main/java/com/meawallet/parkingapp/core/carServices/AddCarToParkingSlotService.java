package com.meawallet.parkingapp.core.carServices;

import com.meawallet.parkingapp.core.port.in.carUseCases.AddCarToParkingSlotUseCase;
import com.meawallet.parkingapp.core.port.out.carPorts.AddCarPort;
import com.meawallet.parkingapp.core.port.out.carPorts.SaveCarPort;
import com.meawallet.parkingapp.core.port.out.parkingLotPorts.FindParkingLotByIdPort;
import com.meawallet.parkingapp.core.port.out.parkingLotPorts.SaveParkingLotPort;
import com.meawallet.parkingapp.core.port.out.parkingLotPorts.SubtractEmptyParkingSlotPort;
import com.meawallet.parkingapp.core.port.out.parkingSlotPorts.FindParkingSlotByIdPort;
import com.meawallet.parkingapp.core.port.out.parkingSlotPorts.SaveParkingSlotPort;
import com.meawallet.parkingapp.domain.Car;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class AddCarToParkingSlotService implements AddCarToParkingSlotUseCase {
    private final FindParkingSlotByIdPort findParkingSlotByIdPort;
    private final FindParkingLotByIdPort findParkingLotByIdPort;
    private final SaveCarPort saveCarPort;
    private final SaveParkingSlotPort saveParkingSlotPort;
    private final SaveParkingLotPort saveParkingLotPort;
    private final SubtractEmptyParkingSlotPort subtractEmptyParkingSlotPort;
    private final AddCarPort addCarPort;
    @Override
    public void addCarToParkingSlotById(Car car, Integer slotId) {

        var parkingSlot = findParkingSlotByIdPort.findById(slotId)
                .orElseThrow(()->new IllegalArgumentException("Parking Slot with this id doesn't exist"));
        log.debug("PARKING SLOT found by id: {}", slotId);

        var savedCar = saveCarPort.save(car);

        parkingSlot.setCar(savedCar);
        log.debug("car value is set for PARKING SLOT with id: {}", slotId);

        parkingSlot.setEmpty(false);
        log.debug("isEmpty value is set for PARKING SLOT with id: {}", slotId);


        saveParkingSlotPort.save(parkingSlot);

        // TODO find parkingLotBySlotId
        var parkingLot = findParkingLotByIdPort.findById(1)
                .orElseThrow(()->new IllegalArgumentException("Parking lot with this id doesn't exist"));

        parkingLot.setEmptySlots(parkingLot.getEmptySlots()-1);
        log.debug("emptySlots value is set for PARKING LOT with id: {}", parkingLot.getId());

        subtractEmptyParkingSlotPort.subtractEmptySlot(parkingLot.getId());

        saveParkingLotPort.save(parkingLot);
    }

    @Override
    public void addCar(Car car, Integer slotId) {
        addCarPort.addCarToParkingLot(car, slotId);

     //   log.debug("emptySlots value is set for PARKING LOT with id: {}", slotId);

    }
}
