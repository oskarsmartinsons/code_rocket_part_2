package com.meawallet.parkingapp.core.port.in.parkingLotUseCases;

import com.meawallet.parkingapp.domain.ParkingSlot;

import java.util.List;

public interface FindParkingSlotsByParkingLotUseCase {
    List<ParkingSlot> findParkingSlotsByParkingLotId(Integer parkingLotId);
}
