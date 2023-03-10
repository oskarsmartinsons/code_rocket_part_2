package com.meawallet.parkingapp.repository.adapter.car;

import com.meawallet.parkingapp.core.port.out.carPorts.DeleteCarPort;
import com.meawallet.parkingapp.repository.repository.CarRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
@Slf4j
@Component
@AllArgsConstructor
public class DeleteCarByIdAdapter implements DeleteCarPort {
    private final CarRepository carRepository;
    @Override
    public void deleteById(Integer id) {

        carRepository.deleteById(id);
        log.debug("CAR with id: {} deleted", id);
    }
}
