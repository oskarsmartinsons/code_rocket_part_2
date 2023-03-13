package com.meawallet.parkingapp.repository.adapter.parkingLot;

import com.meawallet.parkingapp.core.port.out.parkingLotPorts.SubtractEmptyParkingSlotPort;
import com.meawallet.parkingapp.repository.repository.ParkingLotRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class SubtractEmptySlotAdapter implements SubtractEmptyParkingSlotPort {
    private final ParkingLotRepository parkingLotRepository;
    @Override
    public void subtractEmptySlot(Integer slotId) {
        parkingLotRepository.subtractEmptySlot(slotId);
        log.debug("emptySlots value is subtracted for PARKING LOT with slot id: {}", slotId);
    }
}
