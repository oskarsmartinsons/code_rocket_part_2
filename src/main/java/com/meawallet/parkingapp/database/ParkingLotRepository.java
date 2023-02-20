package com.meawallet.parkingapp.database;



import com.meawallet.parkingapp.database.converter.ParkingLotDomainToParkingLotEntity;
import com.meawallet.parkingapp.database.converter.ParkingLotEntityToParkingLotDomain;
import com.meawallet.parkingapp.domain.ParkingLot;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ParkingLotRepository {

    private static Integer idSequence = 1;
    private final HashMap<Integer, ParkingLotEntity> repository;

    private final ParkingLotDomainToParkingLotEntity converterDomainToEntity;

    private final ParkingLotEntityToParkingLotDomain converterEntityToDomain;

    public void save (ParkingLot parkingLot) {
        ParkingLotEntity entity = converterDomainToEntity.convert(parkingLot, idSequence);
        idSequence++;
        repository.put(entity.getId(), entity);
    }

    public ParkingLot getParkingLotById(Integer id) {
       ParkingLotEntity entity = repository.get(id);
       return converterEntityToDomain.convert(entity);
    }

    public Optional<ParkingLot> findParkingLotById(Integer id) {
        return Optional.ofNullable(
                repository.get(id))
                .map(converterEntityToDomain::convert);
    }

    public List<ParkingLot> getAllParkingLots() {
        return repository.values().stream()
                .map(converterEntityToDomain::convert)
                .collect(Collectors.toList());
    }
}
