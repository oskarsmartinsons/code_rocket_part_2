package com.meawallet.parkingapp.repository.adapter.parkingLot;

import com.meawallet.parkingapp.core.port.out.parkingLotPorts.UpdateParkingLotPort;
import com.meawallet.parkingapp.domain.ParkingLot;
import com.meawallet.parkingapp.repository.converter.ParkingLotDomainToParkingLotEntity;
import com.meawallet.parkingapp.repository.converter.ParkingLotEntityToParkingLotDomain;
import com.meawallet.parkingapp.repository.repository.ParkingLotRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
@Slf4j
@Component
@AllArgsConstructor
public class UpdateParkingLotAdapter implements UpdateParkingLotPort {
    private final ParkingLotRepository parkingLotRepository;
    private final ParkingLotDomainToParkingLotEntity parkingLotDomainToParkingLotEntity;
    private final ParkingLotEntityToParkingLotDomain parkingLotEntityToParkingLotDomain;
    @Override
    public ParkingLot update(ParkingLot parkingLot) {
        var entity = parkingLotDomainToParkingLotEntity.convert(parkingLot);
        parkingLotRepository.save(entity);
        log.debug("PARKING LOT entity updated successfully: {}", entity);

        return parkingLotEntityToParkingLotDomain.convert(entity);
    }
}
