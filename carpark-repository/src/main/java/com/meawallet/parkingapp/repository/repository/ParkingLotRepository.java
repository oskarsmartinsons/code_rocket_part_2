package com.meawallet.parkingapp.repository.repository;

import com.meawallet.parkingapp.domain.ParkingLot;
import java.util.List;
import java.util.Optional;

public interface ParkingLotRepository {
    ParkingLot save(ParkingLot parkingLot);
    Optional<ParkingLot> getParkingLotById(Integer id);
    ParkingLot update(ParkingLot parkingLot);
    void delete(ParkingLot parkingLot);
    List<ParkingLot> getAllParkingLots();
   //  void saveWithSlots(ParkingLot parkingLot);
}