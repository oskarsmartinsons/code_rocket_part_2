package com.meawallet.parkingapp.repository.repository;

import com.meawallet.parkingapp.repository.entity.ParkingSlotEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingSlotRepository extends JpaRepository<ParkingSlotEntity, Integer> {
  //  ParkingSlot save(ParkingSlot parkingSlot);
  //  Optional<ParkingSlot> getParkingSlotById(Integer id);
 //   ParkingSlot update(ParkingSlot parkingSlot);
 //   void delete(ParkingSlot parkingSlot);
  //  public List<ParkingSlot> getAllParkingSlots();
}
