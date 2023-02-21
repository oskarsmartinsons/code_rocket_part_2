package com.meawallet.parkingapp.database;


import com.meawallet.parkingapp.database.converter.ParkingLotDomainToParkingLotEntity;
import com.meawallet.parkingapp.database.converter.ParkingSlotDomainToParkingSlotEntity;
import com.meawallet.parkingapp.database.converter.ParkingSlotEntityToParkingSlotDomain;
import com.meawallet.parkingapp.domain.ParkingSlot;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ParkingSlotRepository {
    private static Integer idSequence=1;
    private final HashMap<Integer, ParkingSlotEntity> repository;
    private final ParkingSlotDomainToParkingSlotEntity converterSlotDomainToEntity;
    private final ParkingSlotEntityToParkingSlotDomain converterSlotEntityToDomain;

    public void save(ParkingSlot slot) {
        ParkingSlotEntity entity = converterSlotDomainToEntity.convert(slot,idSequence);
        idSequence++;
        repository.put(idSequence, entity);
    }




   public List<ParkingSlot> getAllParkingSlotsByParkingLotId(Integer parkingLotId) {
        return repository.values().stream()
                .filter(entity->entity.getParkingLotId().equals(parkingLotId))
                .map(converterSlotEntityToDomain::convert)
                .collect(Collectors.toList());
    }

}
