package com.meawallet.parkingapp.database;

import com.meawallet.parkingapp.domain.ParkingLot;

import java.util.List;
import java.util.Optional;

public interface ParkingLotRepository {
    public ParkingLotEntity save(ParkingLot parkingLot);
    public Optional<ParkingLot> getParkingLotById(Integer id);
    public ParkingLotEntity update(ParkingLot parkingLot);
    public void delete(ParkingLot parkingLot);
    public List<ParkingLot> getAllParkingLots();
    public void saveWithSlots(ParkingLot parkingLot);

}