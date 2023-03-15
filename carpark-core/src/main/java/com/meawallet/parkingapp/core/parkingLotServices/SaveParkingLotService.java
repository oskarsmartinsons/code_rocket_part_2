package com.meawallet.parkingapp.core.parkingLotServices;

import com.meawallet.parkingapp.core.port.in.parkingLotUseCases.SaveParkingLotUseCase;
import com.meawallet.parkingapp.core.port.out.guardPorts.GetRandomGuardPort;
import com.meawallet.parkingapp.core.port.out.guardPorts.SaveGuardPort;
import com.meawallet.parkingapp.core.port.out.parkingLotPorts.SaveParkingLotPort;
import com.meawallet.parkingapp.domain.ParkingLot;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class SaveParkingLotService implements SaveParkingLotUseCase {
    private final SaveParkingLotPort saveParkingLotPort;
    private final GetRandomGuardPort getRandomGuardPort;
    private final SaveGuardPort saveGuardPort;

    @Override
    public ParkingLot saveParkingLot(ParkingLot parkingLot) {
        if(parkingLot==null) {throw new IllegalArgumentException("ParkingLot arg is invalid");}

        var guard = getRandomGuardPort.getRandomGuard();
        log.debug("Guard generated: {}", guard);
        var savedGuard = saveGuardPort.saveGuard(guard);
        var parkingLotWithGuard = parkingLot.toBuilder()
                .guard(savedGuard)
                .build();

        return saveParkingLotPort.save(parkingLotWithGuard);
    }
}
