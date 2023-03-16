
package com.meawallet.parkingapp.core.port.in.parkingLotUseCases;

import com.meawallet.parkingapp.core.exception.ParkingLotCreateRequestException;
import com.meawallet.parkingapp.domain.ParkingLot;

public interface SaveParkingLotUseCase {
  ParkingLot saveParkingLot (ParkingLot parkingLot);
}

