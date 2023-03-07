package com.meawallet.parkingapp.core.carServices;

import com.meawallet.parkingapp.core.port.in.carUseCases.DeleteCarUseCase;
import com.meawallet.parkingapp.core.port.out.carPorts.DeleteCarPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeleteCarService implements DeleteCarUseCase {
    private final DeleteCarPort deleteCarPort;
    @Override
    public void deleteCarById(Integer id) {
        deleteCarPort.deleteById(id);
    }
}
