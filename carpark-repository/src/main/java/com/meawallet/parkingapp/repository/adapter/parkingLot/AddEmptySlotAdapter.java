package com.meawallet.parkingapp.repository.adapter.parkingLot;

import com.meawallet.parkingapp.core.port.out.parkingLotPorts.AddEmptyParkingSlotPort;
import com.meawallet.parkingapp.repository.repository.ParkingLotRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class AddEmptySlotAdapter implements AddEmptyParkingSlotPort {
    private final ParkingLotRepository parkingLotRepository;
    @Override
    public void addEmptySlotForLot(Integer slotId) {
        parkingLotRepository.addEmptySlot(slotId);

        log.debug("emptySlot count increased by +1");
    }
}
