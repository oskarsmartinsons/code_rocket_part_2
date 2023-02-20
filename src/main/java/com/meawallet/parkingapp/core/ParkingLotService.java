package com.meawallet.parkingapp.core;

import com.meawallet.parkingapp.database.ParkingLotRepository;
import com.meawallet.parkingapp.domain.ParkingLot;
import com.meawallet.parkingapp.ui.exceptions.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ParkingLotService {
    ParkingLotRepository parkingLotRepository;
    public void save (ParkingLot parkingLot) {
        parkingLotRepository.save(parkingLot);
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
}
