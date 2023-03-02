package com.meawallet.parkingapp.core;

import com.meawallet.parkingapp.core.port.in.UpdateParkingLotUseCase;
import com.meawallet.parkingapp.core.port.out.FindParkingLotByIdPort;
import com.meawallet.parkingapp.core.port.out.SaveParkingLotPort;
import com.meawallet.parkingapp.core.port.out.UpdateParkingLotPort;
import com.meawallet.parkingapp.domain.ParkingLot;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UpdateParkingLotService implements UpdateParkingLotUseCase {
    private final FindParkingLotByIdPort findParkingLotByIdPort;
    private final UpdateParkingLotPort updateParkingLotPort;
    private final SaveParkingLotPort saveParkingLotPort;
/*    @Override
    public void updateParkingLot(Integer id, ParkingLot updatedParkingLot) {
        var existingParkingLot = findParkingLotByIdPort.findById(updatedParkingLot.getId())
                .orElseThrow(()->new IllegalArgumentException("Parking Lot not found"));

        updateParkingLotPort.update(updatedParkingLot);
    }*/

    @Override
    public ParkingLot updateParkingLot(Integer id, ParkingLot updatedParkingLot) {
/*        var optionalResource = findParkingLotByIdPort.findById(id);
        if (optionalResource.isPresent()) {
            var existingResource = optionalResource.get();
            existingResource = ParkingLot.builder()
                    .id(existingResource.getId())
                    .name(updatedParkingLot.getName())
                    .slotCount(updatedParkingLot.getSlotCount())
                    .emptySlots(updatedParkingLot.getEmptySlots())
                    .build();


            return updateParkingLotPort.update(existingResource);

        } else {
            throw new IllegalArgumentException("Resource with ID " + id + " not found");
        }*/

/*        var existingParkingLot = findParkingLotByIdPort.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Parking Lot not found"));

        var parkingLotForUpdate = ParkingLot.builder()
                .id(existingParkingLot.getId())
                .name(updatedParkingLot.getName())
                .slotCount(updatedParkingLot.getSlotCount())
                .emptySlots(updatedParkingLot.getEmptySlots())
                .build();*/

        var parkingLotForUpdate = findParkingLotByIdPort.findById(id)
                .map(existingParkingLot -> ParkingLot.builder()
                        .id(existingParkingLot.getId())
                        .name(updatedParkingLot.getName())
                        .slotCount(updatedParkingLot.getSlotCount())
                        .emptySlots(updatedParkingLot.getEmptySlots())
                        .build())
                .orElseThrow(()->new IllegalArgumentException("Parking Lot not found"));
        return updateParkingLotPort.update(parkingLotForUpdate);
    }
}
