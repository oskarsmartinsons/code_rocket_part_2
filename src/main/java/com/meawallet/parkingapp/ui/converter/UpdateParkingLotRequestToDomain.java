package com.meawallet.parkingapp.ui.converter;

import com.meawallet.parkingapp.domain.ParkingLot;
import com.meawallet.parkingapp.dto.UpdateParkingLotRequest;
import org.springframework.stereotype.Component;

@Component
public class UpdateParkingLotRequestToDomain {
    public ParkingLot convert(UpdateParkingLotRequest request) {
        return ParkingLot.builder()
                .name(request.getName())
                .build();
    }
}
