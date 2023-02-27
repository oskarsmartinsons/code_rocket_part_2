package com.meawallet.parkingapp.core;

import com.meawallet.parkingapp.database.ParkingLotRepository;
import com.meawallet.parkingapp.database.ParkingSlotRepository;
import com.meawallet.parkingapp.domain.ParkingLot;
import com.meawallet.parkingapp.ui.exceptions.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Component;

@Value
@Component
@AllArgsConstructor
public class ParkingLotService {
    ParkingLotRepository parkingLotRepository;
    ParkingSlotRepository parkingSlotRepository;

    public void createParkingLot(ParkingLot parkingLot) {
        if(parkingLot==null) {throw new IllegalArgumentException("ParkingLot arg is invalid");}
        parkingLotRepository.save(parkingLot);
    }

    public void createParkingLotWithSlots(ParkingLot parkingLot) {
        parkingLotRepository.saveWithSlots(parkingLot);
    }

    public ParkingLot findParkingLotById(Integer id) {
        if(id==null) {throw new IllegalArgumentException("Id arg is invalid");}
        return parkingLotRepository.getParkingLotById(id)
                .orElseThrow(()->new EntityNotFoundException("Parking Lot not Found"));
    }

    public void updateParkingLot(ParkingLot updatedParkingLot) {
        if(updatedParkingLot==null) {throw new IllegalArgumentException("ParkingLot arg is invalid");}
        parkingLotRepository.update(updatedParkingLot);
    }

    public void deleteParkingLot(ParkingLot parkingLot) {
        if(parkingLot==null) {throw new IllegalArgumentException("ParkingLot arg is invalid");}
        parkingLotRepository.delete(parkingLot);
    }

    public void showParkingLots() {
        var parkingLotList = parkingLotRepository.getAllParkingLots();
        if(parkingLotList.isEmpty()) {
            System.out.println("There isn't any Parking Lot created yet");
        } else {
            parkingLotList.forEach(System.out::println);
        }
    }

    public void showParkingSlotsByParkingLotId(Integer parkingLotId) {
        var parkingSlots = parkingSlotRepository.getAllParkingSlotsByParkingLotId(parkingLotId);
        parkingSlots.stream().forEach(System.out::println);
    }
}
