package com.meawallet.parkingapp.repository.adapter.parkingSlot;

import com.meawallet.parkingapp.core.port.out.parkingSlotPorts.DeleteParkingSlotPort;
import com.meawallet.parkingapp.repository.repository.ParkingSlotRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
@Slf4j
@Component
@AllArgsConstructor
public class DeleteParkingSlotAdapter implements DeleteParkingSlotPort {
    private final ParkingSlotRepository parkingSlotRepository;

    public void deleteById(Integer id) {

        parkingSlotRepository.deleteById(id);
        log.debug("PARKING SLOT with id: {} deleted", id);

    }
}
