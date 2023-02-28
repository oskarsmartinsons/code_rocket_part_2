package com.meawallet.parkingapp.core.port.in;

//import com.meawallet.parkingapp.core.ParkingLotService;
import com.meawallet.parkingapp.domain.ParkingLot;

public interface SaveParkingLotUseCase {
  void saveParkingLot (ParkingLot parkingLot);
}
