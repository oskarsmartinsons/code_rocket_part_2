package com.meawallet.parkingapp.repository.repository;

import com.meawallet.parkingapp.repository.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Integer> {

    @Transactional
    @Modifying
    @Query("update ParkingSlotEntity p set p.carEntity = ?1, p.isEmpty = false where p.id = ?2")
    void addCarToParkingSlot(CarEntity carEntity, Integer slotId);

    @Transactional
    @Modifying
    @Query("update ParkingSlotEntity p set p.carEntity = null, p.isEmpty = true where p.id = ?1")
    void removeCarFromParkingSlot(Integer slotId);
}
