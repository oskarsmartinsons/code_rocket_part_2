package com.meawallet.parkingapp.core.port.in.parkingSlotUseCases;

import com.meawallet.parkingapp.exception.EntityNotFoundException;
import com.meawallet.parkingapp.domain.ParkingSlot;

public interface FindParkingSlotUseCase {
    ParkingSlot findParkingSlotById(Integer id) throws EntityNotFoundException;
}
