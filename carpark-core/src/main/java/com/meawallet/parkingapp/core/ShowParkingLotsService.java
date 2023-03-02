package com.meawallet.parkingapp.core;

import com.meawallet.parkingapp.core.port.in.ShowParkingLotsUseCase;
import com.meawallet.parkingapp.core.port.out.ShowParkingLotsPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ShowParkingLotsService implements ShowParkingLotsUseCase {
    private final ShowParkingLotsPort showParkingLotsPort;
    @Override
    public void showParkingLots() {
        var parkingLotList = showParkingLotsPort.getAll();
        if(parkingLotList.isEmpty()) {
            System.out.println("There isn't any Parking Lot created yet");
        } else {
            parkingLotList.forEach(System.out::println);
        }
    }
}
