/*

package com.meawallet.parkingapp.core;

import com.meawallet.parkingapp.core.port.in.FindParkingLotUseCase;
import com.meawallet.parkingapp.core.port.out.FindParkingLotByIdPort;
import com.meawallet.parkingapp.domain.ParkingLot;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FindParkingLotService implements FindParkingLotUseCase {
    private final FindParkingLotByIdPort findParkingLotByIdPort;

    @Override
    public ParkingLot findParkingLotById(Integer id) {
        if(id==null) {throw new IllegalArgumentException("Id arg is invalid");}
        return findParkingLotByIdPort.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Parking Lot not Found"));
    }
}

*/
