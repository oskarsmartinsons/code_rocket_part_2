package com.meawallet.parkingapp.repository.repository;

import com.meawallet.parkingapp.repository.entity.GuardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuardRepository extends JpaRepository<GuardEntity, Integer> {
}
