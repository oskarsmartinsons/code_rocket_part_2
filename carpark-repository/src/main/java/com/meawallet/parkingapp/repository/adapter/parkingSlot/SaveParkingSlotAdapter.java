package com.meawallet.parkingapp.repository.adapter.parkingSlot;

import com.meawallet.parkingapp.core.port.out.parkingSlotPorts.SaveParkingSlotPort;
import com.meawallet.parkingapp.domain.ParkingSlot;
import com.meawallet.parkingapp.repository.converter.ParkingSlotDomainToParkingSlotEntity;
import com.meawallet.parkingapp.repository.converter.ParkingSlotEntityToParkingSlotDomain;
import com.meawallet.parkingapp.repository.repository.ParkingSlotRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
@Slf4j
@Component
@Transactional
@AllArgsConstructor
public class SaveParkingSlotAdapter implements SaveParkingSlotPort {
    private final ParkingSlotRepository parkingSlotRepository;
    private final ParkingSlotDomainToParkingSlotEntity parkingSlotDomainToParkingSlotEntity;
    private final ParkingSlotEntityToParkingSlotDomain parkingSlotEntityToParkingSlotDomain;

    @Override
    public ParkingSlot save(ParkingSlot parkingSlot) {
        var entity = parkingSlotDomainToParkingSlotEntity.convert(parkingSlot);
        parkingSlotRepository.saveAndFlush(entity);
        log.debug("PARKING SLOT: {} saved successfully", entity);
        return parkingSlotEntityToParkingSlotDomain.convert(entity);
    }
}
