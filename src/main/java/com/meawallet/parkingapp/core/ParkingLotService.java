package com.meawallet.parkingapp.core;

import com.meawallet.parkingapp.database.ParkingLotRepository;
import com.meawallet.parkingapp.database.ParkingSlotRepository;
import com.meawallet.parkingapp.domain.ParkingLot;
import com.meawallet.parkingapp.domain.ParkingSlot;
import com.meawallet.parkingapp.ui.exceptions.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ParkingLotService {
    ParkingLotRepository parkingLotRepository;
    ParkingSlotRepository parkingSlotRepository;
    public void createParkingLot(ParkingLot parkingLot) {
        parkingLotRepository.save(parkingLot);
    }

    public void createParkingLotWithSlots(ParkingLot parkingLot) {
        parkingLotRepository.saveWithSlots(parkingLot);
    }

    public ParkingLot findById (Integer id) {
        return parkingLotRepository.findParkingLotById(id)
                .orElseThrow(()->new EntityNotFoundException("Parking Lot not Found"));
    }

    public void showParkingLots() {
        var parkingLotList = parkingLotRepository.getAllParkingLots();
        if(parkingLotList.isEmpty()) {
            System.out.println("There isn't any Parking Lot created yet");
        } else {
            parkingLotList.stream()
                    .forEach(System.out::println);
        }
    }

    public void showParkingSlotsByParkingLotId(Integer parkingLotId) {
        var parkingSlots = parkingSlotRepository.getAllParkingSlotsByParkingLotId(parkingLotId);
        parkingSlots.stream().forEach(System.out::println);
    }
}
