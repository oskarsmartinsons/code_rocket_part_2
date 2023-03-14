package com.meawallet.parkingapp.repository.adapter.car;

import com.meawallet.parkingapp.core.port.out.carPorts.AddCarToSlotPort;
import com.meawallet.parkingapp.domain.Car;
import com.meawallet.parkingapp.repository.converter.CarDomainToCarEntityConverter;
import com.meawallet.parkingapp.repository.repository.CarRepository;
import com.meawallet.parkingapp.repository.repository.ParkingLotRepository;
import com.meawallet.parkingapp.repository.repository.ParkingSlotRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
//@Transactional
@AllArgsConstructor
public class AddCarToSlotAdapter implements AddCarToSlotPort {
    private final CarRepository carRepository;
    private final CarDomainToCarEntityConverter carDomainToCarEntityConverter;

    @Override
    public void addCarToParkingSlot(Car car, Integer slotId) {
        var entity = carDomainToCarEntityConverter.convert(car);
        carRepository.save(entity);
        carRepository.addCarToParkingSlot(entity,slotId);
        log.debug("CAR added to PARKING SLOT with id: {}", slotId);

    }
}
