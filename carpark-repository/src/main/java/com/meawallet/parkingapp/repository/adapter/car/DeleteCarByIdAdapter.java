package com.meawallet.parkingapp.repository.adapter.car;

import com.meawallet.parkingapp.core.port.out.carPorts.DeleteCarPort;
import com.meawallet.parkingapp.repository.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeleteCarByIdAdapter implements DeleteCarPort {
    private final CarRepository carRepository;
    @Override
    public void deleteById(Integer id) {
        carRepository.deleteById(id);
    }
}
