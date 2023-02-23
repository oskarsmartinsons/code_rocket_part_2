package com.meawallet.parkingapp.core;

//import com.meawallet.parkingapp.database.ParkingLotHashMapRepository;
import com.meawallet.parkingapp.database.ParkingLotHibernateRepository;
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
   // ParkingLotHibernateRepository parkingLotHibernateRepository;
   // ParkingLotHashMapRepository parkingLotHashMapRepository;
    ParkingLotRepository parkingLotRepository;
    ParkingSlotRepository parkingSlotRepository;
    public void createParkingLot(ParkingLot parkingLot) {
        parkingLotRepository.save(parkingLot);
    }

    public void createParkingLotWithSlots(ParkingLot parkingLot) {
        parkingLotRepository.saveWithSlots(parkingLot);
    }

    public ParkingLot findParkingLotById(Integer id) {
        return parkingLotRepository.getParkingLotById(id)
                .orElseThrow(()->new EntityNotFoundException("Parking Lot not Found"));
    }

    public void updateParkingLot(ParkingLot updatedParkingLot) {
/*        var newName = "updatedName";
        var parkingLotUpdated = ParkingLot.builder()
                .id(updatedParkingLot.getId())
                .name(newName)
                .slotCount(updatedParkingLot.getSlotCount())
                .emptySlots(updatedParkingLot.getEmptySlots())
                .build();
        System.out.println(parkingLotUpdated);
        parkingLotRepository.update(parkingLotUpdated);*/
        parkingLotRepository.update(updatedParkingLot);
    }

    public void deleteParkingLot(ParkingLot parkingLot) {
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
