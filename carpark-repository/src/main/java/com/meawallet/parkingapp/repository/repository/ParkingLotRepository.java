package com.meawallet.parkingapp.repository.repository;

import com.meawallet.parkingapp.domain.ParkingLot;
import com.meawallet.parkingapp.repository.entity.ParkingLotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParkingLotRepository extends JpaRepository<ParkingLotEntity, Integer> {
    Optional<ParkingLotEntity> findById(Integer integer);

    // ParkingLot save(ParkingLot parkingLot);
  //  Optional<ParkingLot> getParkingLotById(Integer id);
  //  ParkingLot update(ParkingLot parkingLot);
 //   void delete(ParkingLot parkingLot);
  //  List<ParkingLot> getAllParkingLots();
   //  void saveWithSlots(ParkingLot parkingLot);
}