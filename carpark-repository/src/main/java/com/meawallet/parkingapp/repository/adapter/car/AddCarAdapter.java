package com.meawallet.parkingapp.repository.adapter.car;

import com.meawallet.parkingapp.core.port.out.carPorts.AddCarPort;
import com.meawallet.parkingapp.domain.Car;
import com.meawallet.parkingapp.repository.converter.CarDomainToCarEntityConverter;
import com.meawallet.parkingapp.repository.repository.CarRepository;
import com.meawallet.parkingapp.repository.repository.ParkingLotRepository;
import com.meawallet.parkingapp.repository.repository.ParkingSlotRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AddCarAdapter implements AddCarPort {
    private final ParkingSlotRepository parkingSlotRepository;
    private final CarRepository carRepository;
    private final CarDomainToCarEntityConverter carDomainToCarEntityConverter;

    private final ParkingLotRepository parkingLotRepository;

    @Override
    public void addCarToParkingLot(Car car, Integer slotId) {
        var entity = carDomainToCarEntityConverter.convert(car);
        carRepository.save(entity);
        parkingSlotRepository.addCarToParkingSlot(entity,slotId);
        parkingLotRepository.subtractEmptySlot(slotId);
    }
}
