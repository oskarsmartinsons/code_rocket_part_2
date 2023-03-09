package com.meawallet.parkingapp.in.dto.parkingLot;


import com.meawallet.parkingapp.domain.ParkingSlot;
import com.meawallet.parkingapp.in.dto.parkingSlot.CreateParkingSlotInRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public record CreateParkingLotInRequest(
        String name,
        Integer slotCount,
        Integer emptySlots,
        Optional<List<CreateParkingSlotInRequest>> createParkingSlotInRequests
){
}
