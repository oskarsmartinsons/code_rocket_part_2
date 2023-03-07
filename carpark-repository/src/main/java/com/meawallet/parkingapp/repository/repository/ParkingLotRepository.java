package com.meawallet.parkingapp.repository.repository;

import com.meawallet.parkingapp.repository.entity.ParkingLotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParkingLotRepository extends JpaRepository<ParkingLotEntity, Integer> {
  //  Optional<ParkingLotEntity> findById(Integer integer);
}