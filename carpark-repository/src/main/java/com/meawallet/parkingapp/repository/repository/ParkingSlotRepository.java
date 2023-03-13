package com.meawallet.parkingapp.repository.repository;

import com.meawallet.parkingapp.domain.Car;
import com.meawallet.parkingapp.domain.ParkingSlot;
import com.meawallet.parkingapp.repository.entity.CarEntity;
import com.meawallet.parkingapp.repository.entity.ParkingSlotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ParkingSlotRepository extends JpaRepository<ParkingSlotEntity, Integer> {
    List<ParkingSlot> findAllById(Integer parkingLotId);
    //List<ParkingSlot> findByParkingLotId(Integer parkingLotId);

    @Transactional
    @Modifying
    @Query("update ParkingSlotEntity p set p.carEntity = ?1, p.isEmpty = false where p.id = ?2")
    void addCarToParkingSlot(CarEntity carEntity, Integer slotId);

}
