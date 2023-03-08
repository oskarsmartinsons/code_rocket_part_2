package com.meawallet.parkingapp.repository.repository;

import com.meawallet.parkingapp.domain.ParkingSlot;
import com.meawallet.parkingapp.repository.entity.ParkingSlotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingSlotRepository extends JpaRepository<ParkingSlotEntity, Integer> {
    //List<ParkingSlot> findByParkingLotId(Integer parkingLotId);
}
