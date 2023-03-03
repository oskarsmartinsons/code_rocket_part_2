package com.meawallet.parkingapp.repository.repository;

import com.meawallet.parkingapp.domain.ParkingSlot;
import java.util.Optional;

public interface ParkingSlotRepository {
    ParkingSlot save(ParkingSlot parkingSlot);
    Optional<ParkingSlot> getParkingSlotById(Integer id);
    ParkingSlot update(ParkingSlot parkingSlot);
    void delete(ParkingSlot parkingSlot);
  //  public List<ParkingSlot> getAllParkingSlots();
}
