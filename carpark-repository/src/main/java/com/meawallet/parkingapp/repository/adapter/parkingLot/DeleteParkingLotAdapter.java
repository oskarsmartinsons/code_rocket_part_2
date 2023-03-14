package com.meawallet.parkingapp.repository.adapter.parkingLot;

import com.meawallet.parkingapp.core.port.out.parkingLotPorts.DeleteParkingLotPort;
import com.meawallet.parkingapp.repository.converter.ParkingLotDomainToParkingLotEntity;
import com.meawallet.parkingapp.repository.repository.ParkingLotRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
@Slf4j
@Component
@AllArgsConstructor
public class DeleteParkingLotAdapter implements DeleteParkingLotPort {
    private final ParkingLotRepository parkingLotRepository;
    @Override
    public void deleteById(Integer id) {
        parkingLotRepository.deleteById(id);
        log.debug("PARKING LOT with id: {} deleted", id);
    }
}
