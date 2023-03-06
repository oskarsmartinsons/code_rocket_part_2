package com.meawallet.parkingapp.repository;

import com.meawallet.parkingapp.core.port.out.SaveParkingLotPort;
import com.meawallet.parkingapp.domain.ParkingLot;
import com.meawallet.parkingapp.repository.converter.ParkingLotDomainToParkingLotEntity;
import com.meawallet.parkingapp.repository.converter.ParkingLotEntityToParkingLotDomain;
import com.meawallet.parkingapp.repository.repository.ParkingLotRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Transactional
@AllArgsConstructor
public class SaveParkingLotAdapter implements SaveParkingLotPort {
    private final ParkingLotRepository parkingLotRepository;
    private final ParkingLotDomainToParkingLotEntity parkingLotDomainToParkingLotEntity;
    private final ParkingLotEntityToParkingLotDomain parkingLotEntityToParkingLotDomain;
    @Override
    public ParkingLot save(ParkingLot parkingLot) {
        var entity = parkingLotDomainToParkingLotEntity.convert(parkingLot);
        parkingLotRepository.save(entity);
        return parkingLotEntityToParkingLotDomain.convert(entity);
    }
}
