/*
package com.meawallet.parkingapp.repository;

import com.meawallet.parkingapp.core.port.out.UpdateParkingLotPort;
import com.meawallet.parkingapp.domain.ParkingLot;
import com.meawallet.parkingapp.repository.converter.ParkingLotDomainToParkingLotEntity;
import com.meawallet.parkingapp.repository.repository.ParkingLotRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UpdateParkingLotAdapter implements UpdateParkingLotPort {
    private final ParkingLotRepository parkingLotRepository;
    private final ParkingLotDomainToParkingLotEntity parkingLotDomainToParkingLotEntity;
    @Override
    public ParkingLot update(ParkingLot parkingLot) {
        var entity = parkingLotDomainToParkingLotEntity.convert(parkingLot);
      //  return parkingLotRepository.save(parkingLot);
        return null;
    }
}
*/
