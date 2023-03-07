package com.meawallet.parkingapp.repository.repository;

import com.meawallet.parkingapp.repository.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Integer> {
}
