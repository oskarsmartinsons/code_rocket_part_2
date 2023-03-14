package com.meawallet.parkingapp.repository.adapter.car;

import com.meawallet.parkingapp.core.port.out.carPorts.RemoveCarFromSlotPort;
import com.meawallet.parkingapp.repository.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RemoveCarFromSlotAdapter implements RemoveCarFromSlotPort {
    private final CarRepository carRepository;
    @Override
    public void removeCarFromParkingSlot(Integer slotId) {
        carRepository.removeCarFromParkingSlot(slotId);
    }
}
