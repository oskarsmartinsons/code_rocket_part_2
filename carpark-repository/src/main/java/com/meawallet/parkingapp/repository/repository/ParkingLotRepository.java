package com.meawallet.parkingapp.repository.repository;

import com.meawallet.parkingapp.repository.entity.ParkingLotEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingLotRepository extends JpaRepository<ParkingLotEntity, Integer> {
  @Transactional
  @Modifying
  @Query("UPDATE ParkingLotEntity p SET p.emptySlots = p.emptySlots - 1 WHERE :slotId MEMBER OF p.parkingSlotEntities")
  void subtractEmptySlot(@Param("slotId") Integer slotId);

}