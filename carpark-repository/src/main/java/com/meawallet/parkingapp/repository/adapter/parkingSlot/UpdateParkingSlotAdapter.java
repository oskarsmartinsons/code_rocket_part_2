package com.meawallet.parkingapp.repository.adapter.parkingSlot;

import com.meawallet.parkingapp.core.port.out.parkingSlotPorts.UpdateParkingSlotPort;
import com.meawallet.parkingapp.domain.ParkingSlot;
import com.meawallet.parkingapp.repository.converter.ParkingSlotDomainToParkingSlotEntity;
import com.meawallet.parkingapp.repository.repository.ParkingSlotRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
@Slf4j
@Component
@AllArgsConstructor
public class UpdateParkingSlotAdapter implements UpdateParkingSlotPort {
    private final ParkingSlotRepository parkingSlotRepository;
    private final ParkingSlotDomainToParkingSlotEntity parkingSlotDomainToParkingSlotEntity;

    @Override
    public void update(ParkingSlot parkingSlot) {
        var entity = parkingSlotDomainToParkingSlotEntity.convert(parkingSlot);
        parkingSlotRepository.save(entity);
        log.debug("PARKING SLOT entity updated successfully: {}", entity);
    }
}
