package com.meawallet.parkingapp.repository.adapter.parkingLot;

import com.meawallet.parkingapp.core.port.out.parkingLotPorts.DeleteParkingLotPort;
import com.meawallet.parkingapp.repository.converter.ParkingLotDomainToParkingLotEntity;
import com.meawallet.parkingapp.repository.repository.ParkingLotRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeleteParkingLotAdapter implements DeleteParkingLotPort {
    private final ParkingLotRepository parkingLotRepository;
    private final ParkingLotDomainToParkingLotEntity parkingLotDomainToParkingLotEntity;
    @Override
    public void deleteById(Integer id) {
      //  var entity = parkingLotDomainToParkingLotEntity.convert(parkingLot);
        parkingLotRepository.deleteById(id);
    }
}
